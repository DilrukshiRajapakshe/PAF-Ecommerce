package com.sliit.paf.dilivery.service.custom;

import com.sliit.paf.dilivery.dto.delivaryDTO;
import com.sliit.paf.dilivery.service.SuperService;

import java.util.List;

public interface ManageDelivaryService extends SuperService {


        List<delivaryDTO> getdelivarys();

        void createdelivary(delivaryDTO dto);

        void updatedelivary(delivaryDTO dto);

        void deletedelivary(String delivaryID);

        delivaryDTO finddelivary(String id);


}
