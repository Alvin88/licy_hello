package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.RoleAuthDaoI;
import com.oc.model.Troletauth;
@Repository("roleauthDao")
public class RoleAuthDaoImpl extends BaseDaoImpl<Troletauth> implements RoleAuthDaoI{

}
