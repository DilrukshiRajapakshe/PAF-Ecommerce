package com.sliit.paf.wishlist.repository;

import com.sliit.paf.wishlist.entity.superEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends superEntity, ID extends Serializable> extends SuperRepository {

    Optional<T> find(ID key);

    Optional<List<T>> findAll();

    void save(T entity);

    void update(T entity);

    void delete(ID key);

}
