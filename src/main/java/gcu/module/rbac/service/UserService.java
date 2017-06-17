package gcu.module.rbac.service;

import gcu.module.rbac.dao.UserDao;
import gcu.module.rbac.daomain.User;
import gcu.shiro.ShiroKit;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haol on 2016/9/9.
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;


    public User queryUserByName(String username,String password) {
        User user = userDao.queryUserByName(username);
        if (user == null){
            throw new UnknownAccountException("用户名不存在");
        }
        String md5Pwd = ShiroKit.md5Pwd(password,username);
        if (!user.getPassword().equals(md5Pwd)){
            throw new IncorrectCredentialsException("密码错误");
        }
        if (user.getStatus() == 0){
            throw new LockedAccountException("用户账号已被锁定");

        }
        return user;
    }

    public User queryUserByName(String username) {
        return userDao.queryUserByName(username);
    }

    /*获取全部角色*/
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    /*根据角色id获取quanbu用户*/
    public List<User> queryUserByRole(int roleId) {
        return userDao.queryUserByRole(roleId);
    }

    public void add(User user){
        user.setPassword(ShiroKit.md5Pwd(user.getPassword(),user.getUsername()));
        userDao.addUser(user);
    }
    public void update(User user){
        userDao.updateUser(user);
    }
    public void delete(int id){
        userDao.deleteUser(id);
    }
    public User queryUserById(int id){
       return userDao.queryUserById(id);
    }

    public int getLastId(){
        return userDao.getLastId();
    }
}
