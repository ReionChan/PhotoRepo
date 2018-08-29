package org.reion.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.reion.impl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public class UserControllerTest extends BaseTest {

    private static Log log = LogFactory.getLog(UserControllerTest.class);

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;

    @Before
    public void setup() {
        // init applicationContext
        this.mockMvc = webAppContextSetup(this.wac).build();
        this.session = new MockHttpSession();
    }

    @Test
    public void goLogin() throws Exception {
        log.info("========Test GET /login ==========");
        this.mockMvc.perform((get("/login"))
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"))
                .andDo(log());
        log.info("PASS");
        log.info("========Test GET /login ==========\n");
    }

    @Test
    public void doLogin() throws Exception {
        log.info("========Test POST /login ==========");
        this.mockMvc.perform((post("/login").param("userName", "reion")
                .param("password", "123"))
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user/reion"))
                .andDo(log());
        log.info("PASS");
        log.info("========Test POST /login ==========\n");
    }

    @Test
    public void doLogout() throws Exception {
        log.info("========Test GET /logout ==========");
        User user = new User();
        user.setName("kido");
        user.setPassword("123");
        session.setAttribute("user", user);
        this.mockMvc.perform((get("/logout")).session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("login"))
                .andDo(log());
        log.info("PASS");
        log.info("========Test GET /logout ==========\n");
    }

    @Test
    public void accessWithOther() throws Exception {
        log.info("========Test GET /user/admin ==========");
        User user = new User();
        user.setId(2);
        user.setName("reion");
        user.setPassword("123");
        session.setAttribute("user", user);
        this.mockMvc.perform((get("/user/admin")).session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/user/reion"))
                .andDo(log());
        log.info("PASS");
        log.info("========Test GET /user/admin ==========\n");
    }

    @Test
    public void noLogin() throws Exception {
        log.info("========Test GET /nologin ==========");
        this.mockMvc.perform((get("/nologin"))
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("login"))
                .andDo(log());
        log.info("PASS");
        log.info("========Test GET /nologin ==========\n");
    }

    @Test
    @Rollback
    public void doRegister() throws Exception {
        log.info("========Test POST /register ==========");
        this.mockMvc.perform((post("/register")
                .param("userName", "kido")
                .param("password", "123"))
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/login.jsp"))
                .andDo(log());
        log.info("PASS");
        log.info("========Test POST /register ==========\n");
    }

    @Test
    @Rollback
    public void doQuite() throws Exception {
        log.info("========Test GET /user/xxx/del ==========");
        User user = new User();
        user.setId(2);
        user.setName("reion");
        user.setPassword("123");
        session.setAttribute("user", user);
        this.mockMvc.perform((get("/user/" + user.getName() + "/del")).session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"))
                .andDo(log());
        log.info("PASS");
        log.info("========Test GET /user/xxx/del ==========\n");
    }
}
