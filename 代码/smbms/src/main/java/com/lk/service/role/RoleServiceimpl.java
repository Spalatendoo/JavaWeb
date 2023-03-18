package com.lk.service.role;

import com.lk.dao.BaseDao;
import com.lk.dao.Role.RoleDao;
import com.lk.dao.Role.RoleDaoimpl;
import com.lk.pojo.Role;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class RoleServiceimpl implements RoleService{
    // 引入Dao
    private RoleDao roleDao;
    public RoleServiceimpl() {
        roleDao = new RoleDaoimpl();
    }
    @Override
    public List<Role> getRoleList()  {
        Connection connection = null;
        List<Role> roleList = null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }


/*    @Test
    public void test(){
        RoleServiceimpl roleServiceimpl = new RoleServiceimpl();
        List<Role> roleList = roleServiceimpl.getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
            System.out.println(role.getRoleCode());
        }
    }*/
}
