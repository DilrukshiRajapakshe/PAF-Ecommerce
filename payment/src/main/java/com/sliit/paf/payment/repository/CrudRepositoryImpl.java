package com.sliit.paf.payment.repository;

import com.sliit.paf.payment.entity.SuperEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
//class Child extends Parent implements Serializable. It implies that the class can be serialized and it's state can be stored on to the disk in a file. when we extend a class that implements serializable we need not specify it again
public abstract class CrudRepositoryImpl<T extends SuperEntity, ID extends Serializable> implements CrudRepository<T,ID> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> entity;

    public CrudRepositoryImpl() {
        entity = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(ID key) {
        getSession().delete(getSession().load(entity, key));
    }

    @Override
    public Optional<T> find(ID key) {
        return Optional.ofNullable(getSession().find(entity, key));
    }

    @Override
    public Optional<List<T>> findAll() {
        return Optional.ofNullable(getSession().createQuery("FROM " + entity.getName()).list());
    }
    @Override
    public Optional<List<T>> findEach(String cid){
        Optional<List<T>> list = null;
        System.out.println(entity.getName());

        if( "com.sliit.paf.payment.entity.OrderDetail"==entity.getName()){
            Query qu = getSession().createQuery("FROM OrderDetail o where o.id = :cid" );
            qu.setParameter("cid",cid);
            list = Optional.ofNullable(qu.list());

        }
        if( "com.sliit.paf.payment.entity.Payment"==entity.getName()) {
            Query qu1 = getSession().createQuery("FROM Payment p where p.customerId = :cid");
            qu1.setParameter("cid", cid);
            list = Optional.ofNullable(qu1.list());
        }

        return list;
    }

}
