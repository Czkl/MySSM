package ssm.service;

import ssm.entity.UserInfo;

import java.util.Map;

public interface IUserService {

    public UserInfo getUserById(String userID);

    String addUser(Map<String, Object> user);

    String delUserById(String userId);

    String upUserById(String userId, Map<String, Object> user);
}
