package com.oc.dao.impl;

import org.springframework.stereotype.Repository;

import com.oc.dao.MenuDaoI;
import com.oc.model.Tmenu;
@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl<Tmenu> implements MenuDaoI{
	
}
