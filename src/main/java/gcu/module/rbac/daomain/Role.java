package gcu.module.rbac.daomain;

/**
 * Created by haol on 2016/9/5.
 */
public class Role {
    private Integer id;
    private String name;
    private String sn;

    /*记录该角色有哪些权限*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
