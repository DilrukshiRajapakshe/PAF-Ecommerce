package com.sliit.paf.registation.service.custom;

import com.sliit.paf.registation.dto.Admindto;
import com.sliit.paf.registation.service.SuperService;


import java.util.List;

public interface adminService extends SuperService {

    List<Admindto> getAdminDetails();

    void createAdminDetails(Admindto dto);

    void updateAdminDetails(Admindto dto);

    void deleteAdminDetails(String userID);

    Admindto findAdminDetails(String userID);
}
