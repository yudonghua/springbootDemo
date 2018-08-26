package cn.yhd.service;

import cn.yhd.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PC on 2018/8/26.
 */
@Service
public interface UserService {
    void addUser(User user);
    User getUser(String username);
    List<User> getAllUser();
}
