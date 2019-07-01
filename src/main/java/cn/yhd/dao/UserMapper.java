package cn.yhd.dao;

import cn.yhd.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by PC on 2018/8/26.
 */
@Mapper
public interface UserMapper {
    List<User> getAllUser();
    List<User> getLikeUser(String username);
    User getUser(String username);


    void deleteUser(String username);
    void addUser(User user);

}
