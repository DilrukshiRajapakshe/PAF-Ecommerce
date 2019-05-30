package com.sliit.paf.registation.service.custom.Impl;



import com.sliit.paf.registation.dto.Customerdto;

import com.sliit.paf.registation.repositroy.custom.customerRepositroy;
import com.sliit.paf.registation.service.Converter;
import com.sliit.paf.registation.service.custom.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class cutomerServiceImpl implements customerService {
    private customerRepositroy customerDAO;

    @Autowired
    public cutomerServiceImpl (customerRepositroy customerDAO ){this.customerDAO = customerDAO ;}
    @Transactional(readOnly = true)

    @Override
    public List<Customerdto> getCustomerDetails() {
        return customerDAO.findAll().map(Converter::<Customerdto>getDTOList).get();
    }

    @Override
    public void createCustomerDetails(Customerdto dto) {customerDAO.save(Converter.getEntity(dto));    }

    @Override
    public void updateCustomerDetails(Customerdto dto) {customerDAO.update(Converter.getEntity(dto));    }

    @Override
    public void deleteCustomerDetails(String userID) {customerDAO.delete(userID);}

    @Override
    public Customerdto findCustomerDetails(String userID) {
        return customerDAO.find(userID).map(Converter::<Customerdto>getDTO).orElse(null);
    }



}


