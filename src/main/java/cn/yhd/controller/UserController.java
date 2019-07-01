package cn.yhd.controller;

import cn.yhd.bean.Friend;
import cn.yhd.bean.User;
import cn.yhd.common.VerifyCode;
import cn.yhd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

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
        User user = userService.getUser(username);
        if(!sessionverify.equalsIgnoreCase(verifycode)){
            model.addAttribute("msg","验证码错误");
            return "/static/login";
        }
        if(!user.getPassword().equals(password)){
            model.addAttribute("msg","密码错误");
            return "/static/login";

        }
        if(AdminController.ADMIN.equals(username)){
            model.addAttribute("list_user",userService.getAllUser());
            req.getSession().setAttribute("username",username);
            return "/static/admin";
        }
        model.addAttribute("list",userService.getFriendByUser(username));
        req.getSession().setAttribute("username",username);
        return "/static/friend";
    }
    @ResponseBody
    @PostMapping("/add/friend")
    public String addFriend(HttpServletRequest req,HttpServletResponse response,String fname) {
        try {
            String username=(String)req.getSession().getAttribute("username");
            Friend friend =new Friend();
            friend.setFriendname(fname);
            friend.setUsername(username);
            userService.addFriend(friend);
        }catch (Exception e){
            return "error";
        }
        return "success";
    }
    @ResponseBody
    @PostMapping("/delete/friend")
    public String deleteFriend(HttpServletRequest req,String fname) {
        String username=(String)req.getSession().getAttribute("username");
        Friend friend =new Friend();
        friend.setFriendname(fname);
        friend.setUsername(username);
        System.out.println(friend);
        userService.deleteFriend(friend);
        friend.setFriendname(username);
        friend.setUsername(fname);
        userService.deleteFriend(friend);
        return "delete success";
    }

    @ResponseBody
    @PostMapping("/allow/friend")
    public String allowFriend(HttpServletRequest req,String fname) {
        String username=(String)req.getSession().getAttribute("username");
        Friend friend =new Friend();
        friend.setFriendname(username);
        friend.setUsername(fname);
        friend.setStatus(1);
        userService.allowFriend(friend);
        friend.setFriendname(fname);
        friend.setUsername(username);
        userService.addFriend(friend);
        userService.allowFriend(friend);
        return "success";
    }
    @PostMapping("/search")
    public String search(Model model,String uname) {
        model.addAttribute("list_user",userService.getLikeUser(uname));
        return "/static/search";
    }
    @GetMapping("/flist")
    public String flist(HttpServletRequest req,Model model) {
        String username=(String)req.getSession().getAttribute("username");
//        String username="东东";
        model.addAttribute("list_friend",userService.getFriendByUser(username));
        return "/static/flist";
    }
    @GetMapping("/req")
    public String req(HttpServletRequest req,Model model) {
        String username=(String)req.getSession().getAttribute("username");
//        String username="东东";
        model.addAttribute("list_req",userService.getReqByUser(username));
        return "/static/req";
    }
    @GetMapping("/friend")
    public String getFriend(Model model,HttpServletRequest req) {

        String username=(String)req.getSession().getAttribute("username");
        if(username==null)return "/static/login";
        model.addAttribute("list_friend",userService.getFriendByUser(username));
        System.out.println(userService.getFriendByUser(username));
        return "/static/friend";
    }
    @GetMapping("/login")
    public String userLogin() {
        return "/static/login";
    }
    @GetMapping("/register")
    public String register() {
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