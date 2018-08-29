package org.reion.api.service;

import org.reion.impl.domain.User;

/**
 * Service interface for User.
 *
 * @author Reion
 * @date 2018-08-11
 * @version 1.0
 **/
public interface IUserService {
    /**
     * Register User.
     *
     * @param user User Object
     * @return boolean true - success
     *                  false - failure
     */
    boolean register(User user);

    /**
     * User Login.
     *
     * @param name User name
     * @param password User password
     * @return User user object
     */
    User login(String name, String password);

    /**
     * User Quit.
     *
     * @param user User Object
     * @return boolean true - success
     *                 false - failure
     */
    boolean quit(User user);
}
