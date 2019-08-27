package cn.yhd.controller;

import cn.yhd.bean.Friend;
import cn.yhd.bean.User;
import cn.yhd.common.VerifyCode;
import cn.yhd.config.TestConfig;
import cn.yhd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    protected static final String ADMIN = "admin";
    @Autowired
    private User user;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return user.getUsername()+"---<<<"+user.getPassword();
    }
    @GetMapping("/admin")
    public String login(Model model,HttpServletRequest req) {
        String username=(String)req.getSession().getAttribute("username");
        if(!ADMIN.equals(username)){

            return "/static/login";

        }
        model.addAttribute("list_user",userService.getAllUser());
        return "/static/admin";
    }
    @ResponseBody
    @PostMapping("/admin/delete")
    public String adminDelete(String username) {
        System.out.println(username);
        userService.deleteUser(username);
        return "delete success";
    }
}