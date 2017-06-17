package gcu.module.rbac.dao;

import gcu.module.rbac.dao.mapper.UserMapper;
import gcu.module.rbac.daomain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haol on 2016/9/9.
 */
@Repository
public class UserDao {
    private Logger logger = LoggerFactory.getLogger(LoginDao.class);

    @Autowired
    private UserMapper mapper;

    /*根据用户名获取用户*/
    public User queryUserByName(String username) {
        try {
            return mapper.queryUserByName(username);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*获取全部角色*/
    public List<User> getUserList() {
        try {
            return mapper.getUserList();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    /*根据角色id获取quanbu用户*/
    public List<User> queryUserByRole(int roleId) {
        try {
            return mapper.queryUserByRole(roleId);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*z增加用户*/
    public void addUser(User user) {
        try {
            mapper.addUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*删除用户*/
    public void deleteUser(int id) {
        try {
            mapper.deleteUser(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*更新用户*/
    public void updateUser(User user) {
        try {
            mapper.updateUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage());

        }
    }

    public User queryUserById(int id) {
        try {
           return mapper.queryUserById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());

            return null;
        }
    }

    public Integer getLastId() {
        try {
           return mapper.lastInsertId();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return 0;
        }
    }
}
