package com.oc.service;

import java.util.List;

import com.oc.dto.Menu;

public interface MenuServiceI {
public List<Menu> getTree(String id);
public List<Menu> getAllTreeNode();
}
