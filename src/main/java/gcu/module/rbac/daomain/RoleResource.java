package gcu.module.rbac.daomain;

/**
 * Created by haol on 2016/9/9.
 */
public class RoleResource {
    private int id;
    private int roleId;
    private int resId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
