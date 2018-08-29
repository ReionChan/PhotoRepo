package org.reion.impl.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.util.Strings;
import org.reion.api.dao.IUserDao;
import org.reion.impl.domain.User;
import org.reion.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Service Implementation.
 *
 * @author Reion
 * @date 2018-08-18
 * @version 1.0
 **/
@Service("uService")
public class UserServiceImpl implements IUserService {

    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    private IUserDao userDao;

    @Autowired
    public UserServiceImpl(IUserDao userDao) {
       this.userDao = userDao;
    }

    @Override
    public User login(String name, String password) {
        if (Strings.isBlank(name) || Strings.isBlank(password)) {
            log.error("Name and Password must not empty!");
            return null;
        }
        return userDao.getUserByNamePassword(name, password);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean quit(User user) {
        return userDao.deleteUserById(user.getId()) > 0;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean register(User user) {
        return userDao.addUser(user) > 0;
    }

}
