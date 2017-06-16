package gcu.module.rbac.dao;

import gcu.module.rbac.dao.mapper.UserMapper;
import gcu.module.rbac.daomain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by haol on 2016/9/4.
 */
@Repository
public class LoginDao {

    private Logger logger = LoggerFactory.getLogger(LoginDao.class);

    @Autowired
    private UserMapper mapper;

    public User queryUserByName(String username){
        try{
            return mapper.queryUserByName(username);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }


    }
}
