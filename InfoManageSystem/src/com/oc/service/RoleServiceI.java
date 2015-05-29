package com.oc.service;

import java.util.List;

import com.oc.dto.DataGrid;
import com.oc.dto.Role;

public interface RoleServiceI {
public DataGrid datagrid(Role role);

public List<Role> combobox();

public void add(Role role);

public void edit(Role role);
public void delete(String ids);
}
