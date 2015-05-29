package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.UserRoleDaoI;
import com.oc.model.Tusertrole;
@Repository("userroleDao")
public class UserRoleDaoImpl extends BaseDaoImpl<Tusertrole> implements UserRoleDaoI {

}
