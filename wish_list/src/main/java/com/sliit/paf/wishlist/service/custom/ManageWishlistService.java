package com.sliit.paf.wishlist.service.custom;

import com.sliit.paf.wishlist.DTObject.wishlistDTO;
import com.sliit.paf.wishlist.service.SuperService;

import java.util.List;

public interface ManageWishlistService extends SuperService {

    List<wishlistDTO> getwishlistDetails();

    void createwishlistDetails(wishlistDTO dto);

    void updatewishlistDetails(wishlistDTO dto);

    void deletewishlistDetails(String itemCode);

    wishlistDTO findWishlistDetails(String itemCode);

}

