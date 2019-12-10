package cn.yhd.service.impl;

import cn.yhd.base.NotNull;
import cn.yhd.bean.Friend;
import cn.yhd.bean.User;
import cn.yhd.dao.FriendMapper;
import cn.yhd.dao.UserMapper;
import cn.yhd.service.UserService;
import cn.yhd.utils.Valid;
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
    @Autowired
    private FriendMapper friendMapper;

    @Valid
    @Override
    public void addUser(@NotNull User user,@NotNull String aaa){
//        userMapper.addUser(user);
    }

    @Override
    public User getUser(String username){
        return userMapper.getUser(username);
    }

    @Override
    public List<User> getAllUser(){return userMapper.getAllUser();}

    @Override
    public List<User> getLikeUser(String username) {
        return userMapper.getLikeUser(username);
    }

    @Override
    public List<Friend> getFriendByUser(String username) {
        return friendMapper.getFriendByUser(username);
    }

    @Override
    public List<Friend> getReqByUser(String username) {
        return friendMapper.getReqByUser(username);
    }

    @Override
    public void addFriend(Friend friend) {
        friendMapper.addFriend(friend);
    }

    @Override
    public void deleteFriend(Friend friend) {


        friendMapper.deleteFriend(friend);
    }

    @Override
    public void deleteUser(String username) {
        userMapper.deleteUser(username);
        friendMapper.clearFriend(username);
    }

    @Override
    public void allowFriend(Friend friend) {
        friendMapper.updateFriend(friend);
    }
}
