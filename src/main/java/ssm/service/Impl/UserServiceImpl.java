package ssm.service.Impl;

import org.springframework.stereotype.Service;
import ssm.dao.base.Dao;
import ssm.entity.UserInfo;
import ssm.service.IUserService;
import ssm.util.UUID;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;
import java.util.Map;

@Service("userService")
public  class UserServiceImpl implements IUserService {

    @Resource(name =  "Dao")
    Dao dao;


    public UserInfo getUserById(String userID) {
        return dao.getByID(userID, UserInfo.class);
    }

    public String addUser(Map<String, Object> user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setProperties(user);
        userInfo.setUserId(UUID.createIDByNowTime());
        return   dao.save(userInfo) + "";
    }

    public String delUserById(String userId) {
        return dao.deleteByID(userId,UserInfo.class)+"";
    }

    public String upUserById(String userId, Map<String, Object> user) {
        UserInfo userInfo = new UserInfo();
        userInfo.setProperties(user);

        return  dao.updatePropByID(userInfo,userId)  + "";
    }


}
