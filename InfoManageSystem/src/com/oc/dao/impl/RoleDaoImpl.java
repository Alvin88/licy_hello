package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.RoleDaoI;
import com.oc.model.Trole;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Trole> implements RoleDaoI{

}
