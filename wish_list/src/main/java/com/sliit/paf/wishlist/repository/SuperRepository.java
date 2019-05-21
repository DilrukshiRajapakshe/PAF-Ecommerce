package com.sliit.paf.wishlist.repository;

import org.hibernate.Session;

public interface SuperRepository {
    Session getSession();
}
