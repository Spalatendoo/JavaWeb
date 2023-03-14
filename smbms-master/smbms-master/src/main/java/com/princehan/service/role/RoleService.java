package com.princehan.service.role;

import com.princehan.dao.role.RoleDao;
import com.princehan.dao.role.RoleDaoImpl;
import com.princehan.pojo.Role;

import java.sql.Connection;
import java.util.List;

/**
 * @Description
 * @Author:PrinceHan
 * @CreateTime:2022/3/9 22:22
 */
public interface RoleService {

    List<Role> getRoleList();
}
