package com.sliit.paf.dilivery.service.custom.Impl;

import com.sliit.paf.dilivery.dto.delivaryDTO;
import com.sliit.paf.dilivery.repository.custom.DelivaryRepository;
import com.sliit.paf.dilivery.service.Converter;
import com.sliit.paf.dilivery.service.custom.ManageDelivaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ManageDelivaryServiceImpl implements ManageDelivaryService {

    private DelivaryRepository delivaryDAO;

    @Autowired
    public ManageDelivaryServiceImpl(DelivaryRepository delivaryDAO) {
        this.delivaryDAO = delivaryDAO;
    }
    @Override
    public List<delivaryDTO> getdelivarys() {
        return delivaryDAO.findAll().map(Converter::<delivaryDTO>getDTOList).get();
    }

    @Override
    public void createdelivary(delivaryDTO dto) {
        delivaryDAO.save(Converter.getEntity(dto));

    }

    @Override
    public void updatedelivary(delivaryDTO dto) {
        delivaryDAO.update(Converter.getEntity(dto));

    }

    @Override
    public void deletedelivary(String delivaryID) {
        delivaryDAO.delete(delivaryID);

    }

    @Override
    public delivaryDTO finddelivary(String id) {
        return delivaryDAO.find(id).map(Converter::<delivaryDTO>getDTO).orElse(null);
    }
}
