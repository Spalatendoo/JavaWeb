package com.princehan.service.role;

import com.princehan.dao.BaseDao;
import com.princehan.dao.role.RoleDao;
import com.princehan.dao.role.RoleDaoImpl;
import com.princehan.pojo.Role;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description
 * @Author:PrinceHan
 * @CreateTime:2022/3/9 22:22
 */
public class RoleServiceImpl implements RoleService{

    //引入Dao
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList() {
        Connection con = null;
        List<Role> roleList = null;
        try {
            con = BaseDao.getConnection();
            roleList = roleDao.getRoleList(con);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(con, null, null);
        }
        return roleList;
    }

    @Test
    public void test() {
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
        }
    }
}
