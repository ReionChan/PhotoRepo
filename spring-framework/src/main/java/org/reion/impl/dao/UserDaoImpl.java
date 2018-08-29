package org.reion.impl.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.reion.api.dao.IUserDao;
import org.reion.impl.dao.data.UserMapper;
import org.reion.impl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User DAO implementation by Spring.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-08-10 15:08:46
 **/
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao {

    private static final Log log = LogFactory.getLog(UserDaoImpl.class);

    @Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<User> getAllUsers() {
        log.debug("getUserById ");
        return getSqlSession().getMapper(UserMapper.class).getAllUsers();
    }

    /**
     * Query User by ID.
     *
     * @param id - User ID
     * @return User - User Object
     */
    @Override
    public User getUserById(Integer id) {
        log.debug("getUserById " + id);
        return getSqlSession().getMapper(UserMapper.class).getUserById(id);
    }

    /**
     * Query User by NAME and PASSWORD.
     *
     * @param name     User name
     * @param password User password
     * @return User
     * @author Reion
     */
    @Override
    public User getUserByNamePassword(String name, String password) {
        log.debug("getUserByNamePassword " + name + " " + password);
        return getSqlSession().getMapper(UserMapper.class)
                .getUserByNamePassword(name, password);
    }

    /**
     * Add a User.
     *
     * @param user User Object
     * @return int
     * @author Reion
     */
    @Override
    public int addUser(User user) {
        log.debug("addUser " + user);
        getSqlSession().getMapper(UserMapper.class).addUser(user);
        return 1;
    }

    /**
     * Delete a User by user ID.
     *
     * @author Reion
     * @param id User ID
     * @return int
     */
    @Override
    public int deleteUserById(Integer id) {
        log.debug("deleteUserById " + id);
        getSqlSession().getMapper(UserMapper.class).deleteUserById(id);
        return 1;
    }

    @Override
    public int updateUser(User user) {
        log.debug("updateUser " + user);
        getSqlSession().getMapper(UserMapper.class).updateUser(user);
        return 1;
    }
}
