package com.sliit.paf.registation.repositroy.custom.Impl;


import com.sliit.paf.registation.entity.Admin;
import com.sliit.paf.registation.repositroy.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;
import com.sliit.paf.registation.repositroy.custom.adminRepositroy;

@Repository
public class adminRepositroyImpl extends CrudRepositoryImpl<Admin, String> implements adminRepositroy{
}
