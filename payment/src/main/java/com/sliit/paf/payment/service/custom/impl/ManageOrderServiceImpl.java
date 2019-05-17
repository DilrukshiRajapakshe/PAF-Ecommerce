package com.sliit.paf.payment.service.custom.impl;

import com.sliit.paf.payment.dto.OrderDetailDTO;
import com.sliit.paf.payment.repository.custom.OrderRepository;
import com.sliit.paf.payment.service.Converter;
import com.sliit.paf.payment.service.custom.ManageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManageOrderServiceImpl implements ManageOrderService {

    private OrderRepository orderDetailDAO;

    @Autowired
    public ManageOrderServiceImpl(OrderRepository customerDAO) {
        this.orderDetailDAO = customerDAO;
    }

    @Transactional(readOnly = true)
    public List<OrderDetailDTO> getOrderDetails(){ return orderDetailDAO.findAll().map(Converter::<OrderDetailDTO>getDTOList).get(); }

    public void createOrderDetail(OrderDetailDTO dto) { orderDetailDAO.save(Converter.getEntity(dto)); }

    public void updateOrderDetail(OrderDetailDTO dto) {
        orderDetailDAO.update(Converter.getEntity(dto));
    }

    public void deleteOrderDetail(String orderID) {
        orderDetailDAO.delete(orderID);
    }

    public OrderDetailDTO findOrderDetail(String orderID){ return orderDetailDAO.find(orderID).map(Converter::<OrderDetailDTO>getDTO).orElse(null); }

}
