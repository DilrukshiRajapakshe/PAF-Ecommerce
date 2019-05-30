package com.sliit.paf.registation.service;

import com.sliit.paf.registation.dto.Admindto;
import com.sliit.paf.registation.dto.Customerdto;
import com.sliit.paf.registation.dto.SuperDTO;
import com.sliit.paf.registation.dto.Userdto;
import com.sliit.paf.registation.entity.Admin;
import com.sliit.paf.registation.entity.Customer;
import com.sliit.paf.registation.entity.SuperEntity;
import com.sliit.paf.registation.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {
        if (entity instanceof Admin) {
            Admin p = (Admin) entity;
            return (T) new Admindto(p.getUserID(), p.getUserName(),p.getEmail());
        }else if (entity instanceof Customer) {
            Customer o = (Customer) entity;
            return (T) new Customerdto(o.getUserID(),o.getUserName(),o.getUserAddress(),o.getPhone(),o.getCreditCardInfo());
        }else if (entity instanceof User) {
            User o = (User) entity;
            return (T) new Userdto(o.getUserID(),o.getPassword(),o.getLoginStatues());
        }else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {
        if (dto instanceof Userdto) {
            Userdto p = (Userdto) dto;
            return (T) new User(p.getUserID(),p.getPassword(),p.getLoginStatues());
        }else if (dto instanceof Customerdto) {
            Customerdto o = (Customerdto) dto;
            return (T) new Customer(o.getUserID(),o.getUserName(),o.getUserAddress(),o.getPhone(),o.getCreditCardInfo());
        }else if (dto instanceof Admindto) {
            Admindto o = (Admindto) dto;
            return (T) new Admin(o.getUserID(),o.getUserName(),o.getEmail());
        }else {
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
