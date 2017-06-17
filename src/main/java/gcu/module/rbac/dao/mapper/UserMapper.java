package gcu.module.rbac.dao.mapper;

import gcu.module.rbac.daomain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haol on 2016/9/4.
 */
@Repository
public interface UserMapper {

    /*check loginname and password is ok AND check loginname is unique*/
    User queryUserByName(@Param("username")String username);

    /*获取全部角色*/
    List<User> getUserList();

    /*根据角色id获取quanbu用户*/
    List<User> queryUserByRole(@Param("roleId") int roleId);

    /*增加用户*/
    void addUser(@Param("user")User user);

    /*删除用户*/
    void deleteUser(@Param("id")int id);

    /*更新用户*/
    void updateUser(@Param("user")User user);

   User queryUserById(@Param("id") int id);

    int lastInsertId();


}
