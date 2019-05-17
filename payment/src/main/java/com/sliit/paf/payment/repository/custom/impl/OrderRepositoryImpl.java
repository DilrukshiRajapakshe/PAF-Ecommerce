package com.sliit.paf.payment.repository.custom.impl;

import com.sliit.paf.payment.entity.OrderDetail;
import com.sliit.paf.payment.repository.CrudRepositoryImpl;
import com.sliit.paf.payment.repository.custom.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends CrudRepositoryImpl<OrderDetail, String> implements OrderRepository {

}
