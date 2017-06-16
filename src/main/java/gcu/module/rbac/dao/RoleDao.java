package gcu.module.rbac.dao;

import gcu.module.rbac.dao.mapper.RoleMapper;
import gcu.module.rbac.daomain.Role;
import gcu.module.rbac.daomain.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haol on 2016/9/9.
 */
@Repository
public class RoleDao {

    private Logger logger = LoggerFactory.getLogger(RoleDao.class);
    @Autowired
    private RoleMapper mapper;

    /*获取角色列表*/
    public List<Role> getRoleList(){
        try {
            return mapper.getRoleList();
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*根据某个用户获取全部角色*/
    public List<Role> queryRoleByUser(int uid){
        try {
            return mapper.queryRoleByUser(uid);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    /*加载用户的UserRole对象*/
    public UserRole loadUserRole(int uid, int roleId){
        try {
            return mapper.loadUserRole(uid,roleId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /* 增加用户角色*/
    public void addUserRole(int uid,int roleId){
        try {
            mapper.addUserRole(uid,roleId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*删除 dange 用户角色*/
    public void deleteUserRole(int uid,int roleId){
        try {
            mapper.deleteUserRole(uid,roleId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*删除某个用户的全部角色*/
    public void deleteUserRoleByUser(int uid){
        try {
            mapper.deleteUserRoleByUser(uid);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*增加角色*/
    public void addRole(Role role){
        try {
            mapper.addRole(role);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    /*删除角色*/
    public void deleteRole(int id){
        try {
            mapper.deleteRole(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    /*更新角色*/
    public void updateRole(Role role){
        try {
            mapper.updateRole(role);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    public Role queryRoleById(int id){
        try{
            return mapper.queryRoleById(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public void deletetUserRoleByRole(int id){
        try{
            mapper.deletetUserRoleByRole(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();

        }
    }
}
