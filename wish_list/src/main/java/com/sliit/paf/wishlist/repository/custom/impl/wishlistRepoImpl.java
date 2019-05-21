package com.sliit.paf.wishlist.repository.custom.impl;

import com.sliit.paf.wishlist.entity.wishlistDetail;
import com.sliit.paf.wishlist.repository.CrudRepositoryImpl;
import com.sliit.paf.wishlist.repository.custom.wishlistRepo;
import org.springframework.stereotype.Repository;

@Repository
public class wishlistRepoImpl extends CrudRepositoryImpl<wishlistDetail, String> implements wishlistRepo {
}
