package gcu.module.rbac.service;

import gcu.module.rbac.dao.ResourceDao;
import gcu.module.rbac.daomain.Resource;
import gcu.module.rbac.daomain.RoleResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haol on 2016/9/9.
 */
@Service
public class ResourceService {

    private Logger logger = LoggerFactory.getLogger(ResourceService.class);

    @Autowired
    private ResourceDao resourceDao;

    /* 获取资源列表*/
    public List<Resource> getResourceList() {
        return resourceDao.getResourceList();
    }


    /*根据角色id获取他可以访问的全部资源*/
    public List<Resource> queryResourceByRole(int roleId) {
        return resourceDao.queryResourceByRole(roleId);
    }

    /*根据用户据=获取该用户可以访问的资源*/
    public List<Resource> queryResourceByUser(int uid) {
        return resourceDao.queryResourceByUser(uid);
    }

    /*zengjia角色资源*/
    public void addRoleResource(int roleId, int resId) {
        resourceDao.addRoleResource(roleId, resId);

    }

    /*删除角色资源*/
    public void delRoleResource(int roleId, int resId) {
        resourceDao.delRoleResource(roleId, resId);

    }
/*删除资源根据*/
    public void deleteRoleResByRole(int roleId) {
        resourceDao.delResResourceByRole(roleId);
    }

    /*加载角色资源*/
    public RoleResource loadRoleResource(int roleId, int resId) {
        return resourceDao.loadRoleResource(roleId, resId);
    }

    /*增加角色*/
    public void addRes(Resource res) {
        resourceDao.addRes(res);

    }

    /*更新角色*/
    public void updateRes(Resource res) {
        resourceDao.updateRes(res);
    }

    /*删除角色*/
    public void deleteRes(int id) {
        resourceDao.deleteRes(id);
    }

    /*根据资源Id删除rr表中的资源*/
    public void deletetRoleResByRes(int id) {
        resourceDao.deletetRoleResByRes(id);
    }

    /*根据id查找资源*/
    public Resource queryResById(int id) {
        return resourceDao.queryResById(id);
    }
}
