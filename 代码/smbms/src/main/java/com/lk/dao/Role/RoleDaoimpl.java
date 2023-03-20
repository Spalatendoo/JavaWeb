package com.lk.dao.Role;

import com.lk.dao.BaseDao;
import com.lk.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoimpl implements RoleDao{
    //获取角色列表
    @Override
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Role> rolelist = new ArrayList<Role>();

        if (connection != null){
            String sql ="select * from smbms_role";
            Object[] params = {};

            rs = BaseDao.execute(connection, sql, params, rs, pstm);

            while (rs.next()){
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("roleName"));
                role.setRoleCode(rs.getString("roleCode"));
                rolelist.add(role);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return rolelist;
    }
}
