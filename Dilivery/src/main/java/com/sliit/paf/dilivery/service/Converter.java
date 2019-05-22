package com.sliit.paf.dilivery.service;


import com.sliit.paf.dilivery.dto.delivaryDTO;
import com.sliit.paf.dilivery.dto.superDTO;
import com.sliit.paf.dilivery.entity.delivary;
import com.sliit.paf.dilivery.entity.SuperEntity;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends superDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof delivary) {
            delivary c = (delivary) entity;
            return (T) new delivaryDTO(c.getUser_id(), c.getDelivary_id(), c.getBill_id(), c.getReceive_date(), c.getReveive_person(), c.getFromTo(), c.getDate());
        } else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(superDTO dto) {
        if (dto instanceof delivaryDTO) {
            delivaryDTO c = (delivaryDTO) dto;
            return (T) new delivary(c.getUser_id(), c.getDelivary_id(), c.getBill_id(), c.getReceive_date(), c.getReveive_person(), c.getFromTo(), c.getDate());
        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends superDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends superDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

//    public static <T extends SuperDTO> List<T> getDTOList(List<CustomEntity> list, Class<T> dtoClass) {
//        return list.stream().map(c -> getDTO(c, dtoClass)).collect(Collectors.toList());
//    }


}
