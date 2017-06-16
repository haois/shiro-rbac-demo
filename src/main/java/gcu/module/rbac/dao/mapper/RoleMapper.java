package gcu.module.rbac.dao.mapper;

import gcu.module.rbac.daomain.Role;
import gcu.module.rbac.daomain.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haol on 2016/9/6.
 */
@Repository
public interface RoleMapper {

    /*获取角色列表*/
    List<Role> getRoleList();

    /*根据某个用户获取全部角色*/
    List<Role> queryRoleByUser(@Param("uid") int uid);


    /*加载用户的UserRole对象*/
    UserRole loadUserRole(@Param("uid") int uid, @Param("roleId") int roleId);

    /* 增加用户角色*/
    void addUserRole(@Param("uid") int uid, @Param("roleId") int roleId);

    /*删除 dange 用户角色*/
    void deleteUserRole(@Param("uid") int uid, @Param("roleId") int roleId);

    /*删除某个用户的全部角色*/
    void deleteUserRoleByUser(@Param("uid") int uid);

    /*增加角色*/
    void addRole(@Param("role") Role role);

    /*删除角色*/
    void deleteRole(@Param("id") int id);

    /*删除用户时，删除user--role中的与次id有关的role*/
    void deletetUserRoleByRole(@Param("roleId") int roleId);

    /*更新角色*/
    void updateRole(@Param("role") Role role);

    /*根绝id得到用户*/
    Role queryRoleById(@Param("id") int id);


}
