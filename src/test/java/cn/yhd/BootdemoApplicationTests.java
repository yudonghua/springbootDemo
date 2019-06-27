package cn.yhd;

import cn.yhd.bean.Friend;
import cn.yhd.dao.FriendMapper;
import cn.yhd.dao.ITbUserMapper;
import cn.yhd.dao.UserMapper;
import cn.yhd.entity.TbUser;
import cn.yhd.entity.TbUserExample;
import cn.yhd.service.ITbUserService;
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
	private ITbUserMapper tbUserMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private ITbUserService tbUserService;
	@Test
	public void test() {
		TbUser user = new TbUser();
		user.setPassword("cc");
		user.setUserName("cc");
//		tbUserMapper.insert(user);
		TbUserExample example = new TbUserExample();
		System.out.println(
				tbUserService.selectByExamplezForPage(example,1,2)
		);
//		Friend friend =new Friend();
//		friend.setFriendname("aaa");
//		friend.setUsername("ccc");
//		userService.deleteFriend(friend);
//		friendMapper.clearFriend("aaa");
//		userService.deleteUser("aaa");
	}

}
