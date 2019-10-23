package cn.yhd.service;

import cn.yhd.bean.User;

/**
 * @author yuhuadong
 * @date 2019/9/21
 */
public class TestService {
    public Boolean isNotNull(User user){
        return user != null;
    }
    public Boolean isUsernameNotNull(Object user){
        return ((User)user).getUsername()!=null;
    }
    public Boolean isPasswordNotNull(Object user){
        return ((User)user).getPassword()!=null;
    }
    public Boolean isUsername(Object user){
        return ((User)user).getUsername().equals("A");
    }
    public Boolean isPassword(Object user){
        return ((User)user).getPassword().equals("B");
    }
}
