package org.reion.api.dao;

import java.util.List;

import org.reion.impl.domain.User;

/**
 * Interface for User DAO.
 *
 * @author Reion
 * @date 2018-08-11
 * @version 1.0
 **/
public interface IUserDao {

    /**
     * Query all users.
     *
     * @author Reion
     * @return java.util.List<User>
     */
    List<User> getAllUsers();

    /**
     * Query one user by ID.
     *
     * @author Reion
     * @param id User ID
     * @return User
     */
    User getUserById(Integer id);

    /**
     * Query one user by name and password.
     *
     * @author Reion
     * @param name User name
     * @param password User password
     * @return User
     */
    User getUserByNamePassword(String name, String password);

    /**
     * Add one user.
     *
     * @author Reion
     * @param user User Object
     * @return int
     */
    int addUser(User user);

    /**
     * Delete one user by ID.
     *
     * @author Reion
     * @param id User ID
     * @return int
     */
    int deleteUserById(Integer id);
    
    /**
     * Update a user.
     *
     * @author Reion
     * @param user User Object
     * @return int
     */
    int updateUser(User user);
}
