package gcu.module.rbac.service;

import gcu.module.rbac.dao.LoginDao;
import gcu.module.rbac.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by haol on 2016/9/4.
 */
@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public User checkLogin(String loginname,String password){
        User user = loginDao.queryUserByName(loginname);
        if (user != null){
            if(user.getPassword().equals(password)){
                return user;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
    public User findUserByName(String loginname){
        return loginDao.queryUserByName(loginname);
    }
}
