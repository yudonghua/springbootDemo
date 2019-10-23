package cn.yhd.controller;

import cn.yhd.base.*;
import cn.yhd.bean.Friend;
import cn.yhd.bean.User;
import cn.yhd.common.VerifyCode;
import cn.yhd.config.TestConfig;
import cn.yhd.service.UserService;
import cn.yhd.thread.NormalThread;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private UserService userService;

    protected static final String ADMIN = "admin";
    @Autowired
    private User user;


    @Resource
    ThreadPoolTaskExecutor normalTaskExecutor;
    @Resource
    ThreadPoolExecutor normalExecutor;
    @Resource
    NormalThread normalThread;
    @Resource
    private ThreadPoolTaskExecutor illegalSelfieAddExecutor;
    @Resource
    private ThreadPoolTaskExecutor illegalSelfieRecordExecutor;

    @GetMapping("/test2")
    @ResponseBody
    @JsonFilter("username")
    public ResponseModel test2() {
        User user = new User();
        user.setUsername("username");
        return ResponseCodeUtils.getSuccessResponseModel(user);
    }
    @GetMapping("/test")
    @ResponseBody
    @JsonView(JSONViewInterface.Video.ViewHot.class)
    public ResponeEntity test() {
        logger.info("test------");
        normalTaskExecutor.execute(()->{
            logger.info(Thread.currentThread().getName());
            try {
                Thread.sleep(10000000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        normalExecutor.execute(()->{
            logger.info(Thread.currentThread().getName());
            try {
                Thread.sleep(10000000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        VTopTableModel vTopTableModel = new VTopTableModel();
//        vTopTableModel.setVtId(1L);
//        vTopTableModel.setVtMid(1L);
//        ResponeEntity responeEntity = new ResponeEntity();
//        responeEntity.setErrorid(0);
//        responeEntity.setErrordesc("操作成功");
//        responeEntity.setVdata(vTopTableModel);
        return new ResponeEntity();
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