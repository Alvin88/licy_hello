package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.AuthDaoI;
import com.oc.model.Tauth;
@Repository("authDao")
public class AuthDaoImpl extends BaseDaoImpl<Tauth> implements AuthDaoI{

}
