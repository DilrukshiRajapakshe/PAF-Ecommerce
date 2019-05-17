package com.sliit.paf.payment.service.custom;

import com.sliit.paf.payment.dto.OrderDetailDTO;
import com.sliit.paf.payment.dto.PaymentDTO;
import com.sliit.paf.payment.service.SuperService;

import java.util.List;

public interface ManageOrderService extends SuperService {

    List<OrderDetailDTO> getOrderDetails();

    void createOrderDetail(OrderDetailDTO dto);

    void updateOrderDetail(OrderDetailDTO dto);

    void deleteOrderDetail(String orderID);

    OrderDetailDTO findOrderDetail(String orderID);


}
