package com.sliit.paf.wishlist.service;

import com.sliit.paf.wishlist.DTObject.SuperDTO;
import com.sliit.paf.wishlist.DTObject.wishlistDTO;
import com.sliit.paf.wishlist.entity.superEntity;
import com.sliit.paf.wishlist.entity.wishlistDetail;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {


    public static <T extends SuperDTO> T getDTO(superEntity entity) {
       if (entity instanceof wishlistDetail) {
            wishlistDetail o = (wishlistDetail) entity;
            return (T) new wishlistDTO(o.getItemCode(),o.getItemDes(),o.getQty(),o.getItemPrice());
        }else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends superEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof wishlistDTO) {
            wishlistDTO o = (wishlistDTO) dto;
            return (T) new wishlistDetail(o.getItemCode(), o.getItemDes(), o.getQty(),o.getItemPrice());
        }else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends superEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends superEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

}
