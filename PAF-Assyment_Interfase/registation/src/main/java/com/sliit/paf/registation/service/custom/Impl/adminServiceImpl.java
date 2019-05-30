package com.sliit.paf.registation.service.custom.Impl;


import com.sliit.paf.registation.dto.Admindto;
import com.sliit.paf.registation.service.Converter;
import com.sliit.paf.registation.service.custom.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sliit.paf.registation.repositroy.custom.adminRepositroy;

import java.util.List;

@Service
@Transactional
public class adminServiceImpl implements adminService {
    private adminRepositroy adminDAO;


 @Autowired
 public adminServiceImpl (adminRepositroy adminDAO ){this.adminDAO = adminDAO ;}
   @Transactional(readOnly = true)


    @Override
    public List<Admindto> getAdminDetails() {
       return adminDAO.findAll().map(Converter::<Admindto>getDTOList).get();
    }

    @Override
    public void createAdminDetails(Admindto dto) {adminDAO.save(Converter.getEntity(dto));    }

    @Override
    public void updateAdminDetails(Admindto dto) {adminDAO.update(Converter.getEntity(dto));    }

    @Override
    public void deleteAdminDetails(String userID) {adminDAO.delete(userID);    }

    @Override
    public Admindto findAdminDetails(String userID) {return adminDAO.find(userID).map(Converter::<Admindto>getDTO).orElse(null);    }


}
