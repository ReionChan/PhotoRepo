package org.reion.impl.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reion.impl.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.reion.impl.web.GlobalConst.SESSION_USER_KEY;

/**
 * 自定义拦截器
 *
 * @author Reion
 * @version 1.0
 * @date 2018-08-18 17:33
 **/
public class UserInterceptor extends HandlerInterceptorAdapter {

    private static Log log = LogFactory.getLog(UserInterceptor.class.getClass());

    /**
     * Regular expression of paths which needed login to access.
     */
    private static final String RX_NEED_LOGIN_PATH = ".*/user/.*";
    private static final String RX_NEED_HOME_PATH = "/login";



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute(SESSION_USER_KEY);
        if (request.getRequestURI().equals(RX_NEED_HOME_PATH) && obj != null) {
            User user = (User) obj;
            log.info("USER ALREADY LOGIN : " + user.getName() + "@" + request.getRemoteHost());
            response.sendRedirect("/user/" + user.getName());
            return false;
        }

        // no login
        if (request.getRequestURI().matches(RX_NEED_LOGIN_PATH) &&  obj == null) {
            log.warn("USER LOGIN DENY: " + request.getRemoteHost());
            response.sendRedirect("/nologin");
            return false;
        }
        return true;
    }
}
