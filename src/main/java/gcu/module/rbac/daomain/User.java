package gcu.module.rbac.daomain;

/**
 * Created by haol on 2016/9/4.
 */
public class User {
    /*用户id*/
    private int id;
    /*用户登录名*/
    private String username;
    /*用户登录密码*/
    private String password;
    /*用户真实姓名*/
    private String nickname;
    /*是否锁定正常为0 锁定为1*/
    private Integer status;

    private String rolesitems;

    public String getRolesitems() {
        return rolesitems;
    }

    public void setRolesitems(String rolesitems) {
        this.rolesitems = rolesitems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
