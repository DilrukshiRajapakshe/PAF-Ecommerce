package com.sliit.paf.payment.service;

import com.sliit.paf.payment.dto.OrderDetailDTO;
import com.sliit.paf.payment.dto.PaymentDTO;
import com.sliit.paf.payment.dto.SuperDTO;
import com.sliit.paf.payment.entity.OrderDetail;
import com.sliit.paf.payment.entity.Payment;
import com.sliit.paf.payment.entity.SuperEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof Payment) {
            Payment p = (Payment) entity;
            return (T) new PaymentDTO(p.getId(), p.getDate(), p.getCustomerId());
        } else if (entity instanceof OrderDetail) {
            OrderDetail o = (OrderDetail) entity;
            return (T) new OrderDetailDTO(o.getOrderDetailID(),o.getOrderId(), o.getItemCode(), o.getQty(), o.getUnitPrice());
        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof PaymentDTO) {
            PaymentDTO p = (PaymentDTO) dto;
            return (T) new Payment(p.getId(), p.getDate(), p.getCustomerId());
        } else if (dto instanceof OrderDetailDTO) {
            OrderDetailDTO o = (OrderDetailDTO) dto;
            return (T) new OrderDetail(o.getOrderDetailID(),o.getOrderId(), o.getItemCode(), o.getQty(), o.getUnitPrice());
        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

}
