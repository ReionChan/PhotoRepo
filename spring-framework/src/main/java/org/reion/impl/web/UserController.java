package org.reion.impl.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.util.Strings;
import org.reion.impl.domain.User;
import org.reion.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

import static org.reion.impl.web.GlobalConst.*;

/**
 * Controller for User.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-08-10
 **/

@Controller
@SessionAttributes(types = {User.class}, value = {SESSION_USER_KEY})
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);

    private IUserService userService;

    /**
     * Inject the user service by Spring DI
     *
     * @param uService User Service
     */
    @Autowired()
    public void setUserService(IUserService uService) {
        this.userService = uService;
    }

    /**
     * A Link for login page.
     *
     * @return java.lang.String
     */
    @GetMapping("/login")
    public String goLogin() {
        return "login";
    }

    /**
     * A Link for login page.
     *
     * @param attributes Redirect value holder
     * @return java.lang.String
     */
    @GetMapping("/nologin")
    public String noLogin(RedirectAttributes attributes) {
        attributes.addFlashAttribute(PAGE_ERROR_KEY, "Sorry, Please login first!");
        return "redirect:login";
    }

    /**
     * A Link for register page.
     *
     * @return java.lang.String register path
     */
    @GetMapping("/register")
    public String goRegister() {
        return "register";
    }

    /**
     * User register
     *
     * @param userName current user name
     * @param password current user password
     * @param model    domain
     * @return java.lang.String after register path
     */
    @PostMapping("/register")
    public String doRegister(@RequestParam String userName,
                             @RequestParam String password, Model model) {
        if (Strings.isBlank(userName) || Strings.isBlank(password)) {
            log.warn("User name or password is null.");
            model.addAttribute(PAGE_ERROR_KEY, "User name or password is null!");
            return "register";
        }
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        userService.register(user);
        log.info("USER REGISTER: " + userName);
        model.addAttribute(PAGE_INFO_KEY, "Register success, please login.");
        return "login";
    }

    /**
     * Login process.
     *
     * @param userName User Name
     * @param password User Password
     * @param model    MVC Model
     * @return java.lang.String After login path
     */
    @PostMapping("/login")
    public ModelAndView doLogin(@RequestParam String userName, @RequestParam String password,
                                Model model) {
        ModelAndView defaultView = new ModelAndView("login");
        if (Strings.isBlank(userName) || Strings.isBlank(password)) {
            model.addAttribute(PAGE_ERROR_KEY, "UserName or Password invalid!");
            return defaultView;
        }

        User user = userService.login(userName, password);
        if (user != null) {
            model.addAttribute(SESSION_USER_KEY, user);
            log.info("USER LOGIN: " + userName);
            defaultView = new ModelAndView("redirect:/user/" + userName);
        } else {
            model.addAttribute(PAGE_ERROR_KEY, "Sorry, Username or Password error!");
        }
        return defaultView;
    }

    /**
     * User logout.
     *
     * @param status session status
     * @param user   current user
     * @return java.lang.String After logout page.
     */
    @RequestMapping("/logout")
    public String doLogout(SessionStatus status, @SessionAttribute User user,
                           RedirectAttributes attributes) {
        log.info("USER LOGOUT: " + user.getName());
        status.setComplete();
        attributes.addFlashAttribute(PAGE_INFO_KEY, "Logout Success!");
        return "redirect:login";
    }

    /**
     * User's home page.
     *
     * @param userName current user name
     * @param user     current user
     * @return home page path
     */
    @RequestMapping("/user/{userName}")
    public String doHome(@PathVariable String userName, @SessionAttribute User user) {
        Objects.requireNonNull(userName);

        log.debug("PATH VAR: " + userName + " SESSION: " + user.getName());
        if (!userName.equals(user.getName())) {
            log.warn("USER TRY ACCESS WRONG AREA!");
            return "redirect:/user/" + user.getName();
        }
        return "home/home";
    }

    /**
     * User delete the account of herself or himself.
     *
     * @param userName   current user name
     * @param user       current user
     * @param status     session status
     * @param attributes Redirect value holder
     * @return java.lang.String After delete account page.
     */
    @GetMapping("/user/{userName}/del")
    public String doDelete(@PathVariable String userName, @SessionAttribute User user, SessionStatus status,
                           RedirectAttributes attributes) {
        Objects.requireNonNull(userName);

        log.debug("PATH VAR: " + userName + " SESSION: " + user.getName());
        if (!userName.equals(user.getName())) {
            log.warn("USER TRY ACCESS WRONG AREA!");
            return "redirect:/user/" + user.getName();
        }

        if (userService.quit(user)) {
            status.setComplete();
            attributes.addFlashAttribute(PAGE_INFO_KEY, "Delete your account successfully.");
            return "redirect:/login";
        }
        return "redirect:/user/" + user.getName();
    }
}
