package cn.yhd.service.impl;

import cn.yhd.bean.User;
import cn.yhd.dao.UserMapper;
import cn.yhd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PC on 2018/8/26.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public void addUser(User user){
        userMapper.addUser(user);
    }
    public User getUser(String username){
        return userMapper.getUser(username);
    }
    public List<User> getAllUser(){return userMapper.getAllUser();}
}
