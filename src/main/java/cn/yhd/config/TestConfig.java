package cn.yhd.config;

import cn.yhd.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: yuhuadong
 * @Date: 2019/8/21 5:59 PM
 * @Description:
 */
@Configuration
public class TestConfig {
    @Value("${test.value}")
    private String testValue;
    @Value("${test.password}")
    private String password;

    @Bean
    public User user() {
        User user = new User();
        user.setUsername(testValue);
        user.setPassword(password);
        return user;
    }
}
