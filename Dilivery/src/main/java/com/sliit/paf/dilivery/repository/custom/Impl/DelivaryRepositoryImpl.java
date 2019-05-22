package com.sliit.paf.dilivery.repository.custom.Impl;

import com.sliit.paf.dilivery.entity.delivary;
import com.sliit.paf.dilivery.repository.CrudRepositoryImpl;
import com.sliit.paf.dilivery.repository.custom.DelivaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DelivaryRepositoryImpl extends CrudRepositoryImpl <delivary,String> implements DelivaryRepository{
}
