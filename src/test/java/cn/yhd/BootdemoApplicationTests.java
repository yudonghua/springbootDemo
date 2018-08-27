package cn.yhd;

import cn.yhd.bean.Friend;
import cn.yhd.dao.FriendMapper;
import cn.yhd.dao.UserMapper;
import cn.yhd.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootdemoApplicationTests {
	@Autowired
	private FriendMapper friendMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
//		Friend friend =new Friend();
//		friend.setFriendname("aaa");
//		friend.setUsername("ccc");
//		userService.deleteFriend(friend);
//		friendMapper.clearFriend("aaa");
		userService.deleteUser("aaa");
	}

}
