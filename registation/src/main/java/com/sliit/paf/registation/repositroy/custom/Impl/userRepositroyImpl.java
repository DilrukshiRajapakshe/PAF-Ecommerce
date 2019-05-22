package com.sliit.paf.registation.repositroy.custom.Impl;

import com.sliit.paf.registation.entity.User;
import com.sliit.paf.registation.repositroy.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;
import com.sliit.paf.registation.repositroy.custom.userRepositroy;

@Repository
public class userRepositroyImpl extends CrudRepositoryImpl<User,String> implements userRepositroy{
}
