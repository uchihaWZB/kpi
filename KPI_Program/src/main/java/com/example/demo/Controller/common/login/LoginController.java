package com.example.demo.Controller.common.login;

import com.example.demo.service.UserService;
import com.example.demo.utils.Constant;
import com.example.demo.utils.returnMessage.ReturnMsg;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 *
 * 真正登录的POST请求由Filter完成,
 */
@Controller
public class LoginController {


    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @RequestMapping(value = "/")
    public String homePage(){

        return "login";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(@RequestParam("loginname") String loginname,
                        @RequestParam("password") String password,
                        @RequestParam(value = "rememberMe", required = false) String rememberMe,
                        Model model) {

        ReturnMsg returnMsg = new ReturnMsg();

        //记住我
        if (StringUtils.isBlank(rememberMe)) {
            System.out.println("rememberMe is null");
        }

        //进行判空操作
        if (StringUtils.isBlank(loginname) && StringUtils.isBlank(password)) {

            returnMsg.setMsg(Constant.NEED_LOGIN_NAME_AND_PASSWORD);

            return "login";
        } else {

            if (userService.findUserByUsernameAndPassword(loginname, password) != null) {

                model.addAttribute(loginname, password);

                return "index";
            } else {

                returnMsg.setMsg(Constant.NOT_HAVE_LOGIN_NAME);

                return "login";
            }

        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("*****logout*******");
        //httpServletRequest.getSession().removeAttribute("/");

        return "login";
    }
}
