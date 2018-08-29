package org.reion.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.reion.impl.domain.User;
import org.reion.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserServiceTest extends BaseTest {

    private static Log log = LogFactory.getLog(UserServiceTest.class);

    @Autowired
    IUserService userService;

    @Before
    public void setup() {
    }

//	@Test
//	public void checkTransaction() {
//		log.info("========Test for transaction ==========");
//		assertTrue(TestTransaction.isActive());
//		assertTrue(TestTransaction.isFlaggedForRollback());
//		log.info("========Test for transaction ==========");
//	}

    @Test
    public void register() {
        log.info("========Test for register ==========");
        User user = new User();
        user.setName("Jackie");
        user.setPassword("123");
        assertTrue(userService.register(user));
        log.info("PASS");
        log.info("========Test for register ==========\n");
    }

    @Test
    @Commit
    public void login() {
        log.info("========Test for login ==========");
        assertNotNull(userService.login("admin", "admin"));
        log.info("PASS");
        log.info("========Test for login ==========\n");
    }
}
