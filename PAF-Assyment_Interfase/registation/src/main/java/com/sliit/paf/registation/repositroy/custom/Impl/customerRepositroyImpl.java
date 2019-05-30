package com.sliit.paf.registation.repositroy.custom.Impl;

import com.sliit.paf.registation.entity.Customer;
import com.sliit.paf.registation.repositroy.CrudRepositoryImpl;
import com.sliit.paf.registation.repositroy.custom.customerRepositroy;
import org.springframework.stereotype.Repository;

@Repository
public class customerRepositroyImpl extends CrudRepositoryImpl <Customer, String> implements customerRepositroy {
}
