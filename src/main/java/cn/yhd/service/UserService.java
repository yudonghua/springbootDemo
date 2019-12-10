package cn.yhd.service;

import cn.yhd.base.NotNull;
import cn.yhd.bean.Friend;
import cn.yhd.bean.User;
import cn.yhd.utils.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PC on 2018/8/26.
 */
@Service
public interface UserService {
    void addUser(User user,String aaa);
    User getUser(String username);
    List<User> getAllUser();
    List<User> getLikeUser(String username);
    List<Friend> getFriendByUser(String username);
    List<Friend> getReqByUser(String username);
    void addFriend(Friend friend);
    void deleteFriend(Friend friend);
    void deleteUser(String username);
    void allowFriend(Friend friend);
}
