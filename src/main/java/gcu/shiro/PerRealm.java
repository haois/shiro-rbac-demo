package gcu.shiro;

import gcu.module.rbac.daomain.Resource;
import gcu.module.rbac.daomain.User;
import gcu.module.rbac.service.ResourceService;
import gcu.module.rbac.service.RoleService;
import gcu.module.rbac.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by haol on 2016/9/9.
 */
public class PerRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(PerRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    /*授权管理*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.queryUserByName(username);
        int uid = user.getId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        logger.info("用户[{}]进入授权验证", username);
        try {

            //获取登录用户的角色列表,该demo中因为是以资源管理，所以未用到，如果使用角色管理则需要
           /*
           List<Role> roles = roleService.queryRoleByUser(uid);
            List<String> rolesStr = new ArrayList<String>();
            for (Role ro : roles) {
                rolesStr.add(ro.getSn());
            }
             info.setRoles(new HashSet<String>(rolesStr));
             */


             //获取登录用户的资源列表，此处直接根据用户id多表关联查询出
            List<Resource> resources = resourceService.queryResourceByUser(uid);
            List<String> permissions = new ArrayList<String>();
            for (Resource res : resources) {
                permissions.add(res.getUrl());
            }

            info.setStringPermissions(new HashSet<String>(permissions));
            logger.info("用户[{}]授权认证完成", username);
            return info;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*登录验证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        String password = new String((char[]) authenticationToken.getCredentials());
        String md5Pwd = ShiroKit.md5Pwd(password, username);
        logger.info("用户[{}]进入登录验证", username);
        User user = userService.queryUserByName(username);

        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        } else {
            if (!user.getPassword().equals(md5Pwd)) {
                throw new IncorrectCredentialsException("密码错误");
            }
            if (user.getStatus().equals("0")) {
                throw new LockedAccountException("用户账号已被锁定");
            }
        }

          /*  *//*将登陆用户的信息存进session*//*
            SecurityContextHolder.setUser(user);*/

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());
        /**
         * 很大的疑惑这个
         *   info.setCredentialsSalt(ByteSource.Util.bytes(password));
         *   应该是设置username这个盐值得可是设置就会出错
         *   设置成password就没问题
         */
        info.setCredentialsSalt(ByteSource.Util.bytes(password));
        logger.info("用户[{}]进入登录验证成功", username);
        return info;
    }
/*
    *//*清除授权的缓存*//*
    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        Cache cache =this.getAuthorizationCache();
        Set<Object> objects = cache.keys();
        for (Object o :objects){
            System.out.println("授权缓存:"+o+"--------"+cache.get(o)+"--------");
        }
        super.clearCachedAuthorizationInfo(principals);
    }

    *//*清除身份认证的缓存*//*
    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        Cache cache = this.getAuthenticationCache();
        Set<Object> objects = cache.keys();
        for (Object o :objects){
            System.out.println("认证缓存:"+o+"--------"+cache.get(o)+"--------");
        }
        User user = ((User) principals.getPrimaryPrincipal());
        SimplePrincipalCollection info = new SimplePrincipalCollection(user.getUsername(),getName());
        super.clearCachedAuthenticationInfo(principals);
    }*/
}
