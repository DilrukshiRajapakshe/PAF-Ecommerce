package com.sliit.paf.registation.service.custom;

import com.sliit.paf.registation.dto.Customerdto;
import com.sliit.paf.registation.dto.Userdto;
import com.sliit.paf.registation.service.SuperService;

import java.util.List;

public interface userService extends SuperService {

    List<Userdto> getUserDetails();

    void createUserDetails(Userdto dto);

    void updateUserDetails(Userdto dto);

    void deleteUserDetails(String userID);

    Userdto findUserDetails(String userID);
}
