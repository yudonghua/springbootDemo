package cn.yhd.controller;

import cn.yhd.bean.User;
import cn.yhd.common.VerifyCode;
import cn.yhd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/VerifyCodeServlet")
    public void VerifyCodeServlet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage(85,23);//设置验证码图片大小
        req.getSession().setAttribute("sessionverify", vc.getText());//将验证码文本保存到session域
        VerifyCode.output(image, response.getOutputStream());
    }
    @PostMapping("/user/login")
    public String login(Model model,HttpServletRequest req,String username,String password, String verifycode) {
        String sessionverify=(String)req.getSession().getAttribute("sessionverify");
        System.out.println(verifycode+sessionverify);
        User user = userService.getUser(username);
        if(!sessionverify.equalsIgnoreCase(verifycode)){
            model.addAttribute("msg","验证码错误");
            return "/static/login";
        }
        if(!user.getPassword().equals(password)){
            model.addAttribute("msg","密码错误");
            return "/static/login";

        }
        model.addAttribute("list",userService.getAllUser());
        return "/static/friend";
    }
    @GetMapping("/friend")
    public String getFriend(Model model) {
        model.addAttribute("list",userService.getAllUser());
        return "/static/friend";
    }
    @GetMapping("/login")
    public String userLogin() {
        return "/static/login";
    }
    @GetMapping("/register")
    public String register(Model model,String username,String password) {
        model.addAttribute("success", true);
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "/static/register";
    }
    @PostMapping("user/register")
    public String userRegister(Model model,String username,String password,String rpsw) {
        if(username.equals("")||password.equals("")||rpsw.equals("")){
            model.addAttribute("msg","用户名或密码不能为空");
            return "/static/register";
        }else if(!password.equals(rpsw)){
            model.addAttribute("msg","密码不一致");
            return "/static/register";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.addUser(user);
        return "/static/login";
    }
}