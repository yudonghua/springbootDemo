package cn.yhd.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.context.annotation.Primary;

import java.security.PrivateKey;
import java.util.Date;

/**
 * Created by PC on 2018/8/26.
 */
public class User {
    private String username;
    private String password;
    private Date createTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
