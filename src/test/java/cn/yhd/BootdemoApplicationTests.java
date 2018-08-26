package cn.yhd;

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
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
		System.out.println(userService.getUser("东东"));
	}

}
