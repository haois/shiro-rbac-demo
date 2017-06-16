package gcu.module.rbac.service;

import gcu.module.rbac.dao.RoleDao;
import gcu.module.rbac.daomain.Role;
import gcu.module.rbac.daomain.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haol on 2016/9/9.
 */
@Service
public class RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private RoleDao roleDao;


    /*获取角色列表*/
    public List<Role> getRoleList() {
        return roleDao.getRoleList();
    }

    /*根据某个用户获取全部角色*/
    public List<Role> queryRoleByUser(int uid) {
        return roleDao.queryRoleByUser(uid);
    }


    /*加载用户的UserRole对象*/
    public UserRole loadUserRole(int uid, int roleId) {
        return roleDao.loadUserRole(uid, roleId);
    }

    /* 增加用户角色*/
    public void addUserRole(int uid, int roleId) {
        roleDao.addUserRole(uid, roleId);
    }

    /*删除 dange 用户角色*/
    public void deleteUserRole(int uid, int roleId) {
        roleDao.deleteUserRole(uid, roleId);
    }

    /*删除某个用户的全部角色*/
    public void deleteUserRoleByUser(int uid) {
        roleDao.deleteUserRoleByUser(uid);
    }

    public void addRole(Role role){
        roleDao.addRole(role);

    }
    public void updateRole(Role role){
        roleDao.updateRole(role);

    }
    public void deleteRole(int id){
        roleDao.deleteRole(id);

    }
    public Role loadRoleById(int id){
        return roleDao.queryRoleById(id);
    }
    public void deletetUserRoleByRole(int id){
         roleDao.deletetUserRoleByRole(id);
    }
}
