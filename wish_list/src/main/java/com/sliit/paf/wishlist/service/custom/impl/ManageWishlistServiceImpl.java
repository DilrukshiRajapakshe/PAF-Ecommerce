package com.sliit.paf.wishlist.service.custom.impl;

import com.sliit.paf.wishlist.DTObject.wishlistDTO;
import com.sliit.paf.wishlist.repository.custom.wishlistRepo;
import com.sliit.paf.wishlist.service.Converter;
import com.sliit.paf.wishlist.service.custom.ManageWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ManageWishlistServiceImpl implements ManageWishlistService {


    private wishlistRepo wishlistDetailDAO;

    @Autowired
    public ManageWishlistServiceImpl(wishlistRepo customerDAO) {
        this.wishlistDetailDAO = customerDAO;
    }

    @Transactional(readOnly = true)
    public List<wishlistDTO> getwishlistDetails(){ return wishlistDetailDAO.findAll().map(Converter::<wishlistDTO>getDTOList).get(); }

    public void createwishlistDetails(wishlistDTO dto) { wishlistDetailDAO.save(Converter.getEntity(dto)); }

    public void updatewishlistDetails(wishlistDTO dto) {
        wishlistDetailDAO.update(Converter.getEntity(dto));
    }

    public void deletewishlistDetails(String itemCode) {wishlistDetailDAO.delete(itemCode);}

    @Override
    public wishlistDTO findWishlistDetails(String itemCode) {
        return wishlistDetailDAO.find(itemCode).map(Converter::<wishlistDTO>getDTO).orElse(null);
    }

}

