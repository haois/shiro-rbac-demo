package gcu.module.rbac.dao;

import gcu.module.rbac.dao.mapper.ResourceMapper;
import gcu.module.rbac.daomain.Resource;
import gcu.module.rbac.daomain.RoleResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by haol on 2016/9/9.
 */
@Repository
public class ResourceDao {

    private Logger logger = LoggerFactory.getLogger(ResourceDao.class);

    @Autowired
    private ResourceMapper mapper;

    /* 获取资源列表*/
    public List<Resource> getResourceList(){
        try{
            return mapper.getResourceList();
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    /*根据角色id获取他可以访问的全部资源*/
    public List<Resource> queryResourceByRole(int roleId){
        try{
            return mapper.queryResourceByRole(roleId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*根据用户据=获取该用户可以访问的资源*/
    public List<Resource> queryResourceByUser(int uid){
        try{
            return mapper.queryResourceByUser(uid);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /*zengjia角色资源*/
    public void addRoleResource(int roleId, int resId){
        try{
            mapper.addRoleResource(roleId, resId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*删除角色资源*/
    public void delRoleResource(int roleId, int resId){
        try{
            mapper.delRoleResource(roleId, resId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    public void delResResourceByRole(int roleId){
        try{
            mapper.delResResourceByRole(roleId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /*加载角色资源*/
    public RoleResource loadRoleResource(int roleId, int resId){
        try{
            return mapper.loadRoleResource(roleId,resId);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void addRes(Resource res) {
        try{
            mapper.addRes(res);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateRes(Resource res) {
        try{
            mapper.updateRes(res);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteRes(int id) {
        try{
            mapper.deleteRes(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    public void deletetRoleResByRes(int id) {
        try{
            mapper.deletetRoleResByRes(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public Resource queryResById(int id) {
        try{
            return mapper.queryResById(id);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


}
