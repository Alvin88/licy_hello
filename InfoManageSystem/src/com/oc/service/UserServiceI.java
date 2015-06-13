package com.oc.service;

import java.io.Serializable;

import com.oc.dto.User;
import com.oc.model.Tuser;
import com.oc.utils.system.DataGrid;

public interface UserServiceI {
public Serializable save(Tuser t);
public User save(User user);
public User login(User user);
public DataGrid datagrid(User user);
public void remove(String ids);
public User edit(User user);
public void editUserInfo(User user);
}
