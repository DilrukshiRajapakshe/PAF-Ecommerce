package com.sliit.paf.registation.service.custom;


import com.sliit.paf.registation.dto.Customerdto;
import com.sliit.paf.registation.service.SuperService;

import java.util.List;

public interface customerService extends SuperService {
    List<Customerdto> getCustomerDetails();

    void createCustomerDetails(Customerdto dto);

    void updateCustomerDetails(Customerdto dto);

    void deleteCustomerDetails(String userID);

    Customerdto findCustomerDetails(String userID);
        }
