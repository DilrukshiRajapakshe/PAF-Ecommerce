package com.sliit.paf.payment.repository.custom;

import com.sliit.paf.payment.entity.OrderDetail;
import com.sliit.paf.payment.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<OrderDetail, String > {

}
