package gcu.shiro;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * Created by haol on 2016/9/12.
 */
public class UrlPermissionResovler implements PermissionResolver{
    public Permission resolvePermission(String s) {
        if (s.startsWith("/")){
            return new UrlPermission(s);
        }else {
            return new WildcardPermission(s);
        }
    }
}
