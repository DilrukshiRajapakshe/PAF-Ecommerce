package com.sliit.paf.registation.service.custom.Impl;

import com.sliit.paf.registation.dto.Customerdto;
import com.sliit.paf.registation.dto.Userdto;
import com.sliit.paf.registation.repositroy.custom.customerRepositroy;
import com.sliit.paf.registation.service.Converter;
import com.sliit.paf.registation.service.custom.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sliit.paf.registation.repositroy.custom.userRepositroy;

import java.util.List;

@Service
@Transactional
public class userServiceImpl implements userService {
    private userRepositroy userDAO;

    @Autowired
    public userServiceImpl (userRepositroy userDAO ){this.userDAO = userDAO ;}
    @Transactional(readOnly = true)


    @Override
    public List<Userdto> getUserDetails() {
        return userDAO.findAll().map(Converter::<Userdto>getDTOList).get();
    }

    @Override
    public void createUserDetails(Userdto dto) {userDAO.save(Converter.getEntity(dto));    }

    @Override
    public void updateUserDetails(Userdto dto) {userDAO.update(Converter.getEntity(dto));   }

    @Override
    public void deleteUserDetails(String userID) {userDAO.delete(userID);    }

    @Override
    public Userdto findUserDetails(String userID) {
        return null;
    }
}
