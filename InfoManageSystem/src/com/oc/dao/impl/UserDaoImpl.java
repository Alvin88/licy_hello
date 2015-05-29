package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.UserDaoI;
import com.oc.model.Tuser;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Tuser> implements UserDaoI {

}
