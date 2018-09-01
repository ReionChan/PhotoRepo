package org.reion.impl.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.reion.api.dao.IUserDao;
import org.reion.impl.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User Mapper Object.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-08-23 01:03
 **/
@Repository("userDao")
public interface UserDaoMapper extends IUserDao {
    /**
     * Query all users.
     *
     * @return java.util.List<User>
     */
    @Override
    List<User> getAllUsers();

    /**
     * Query one user by ID.
     *
     * @param id User ID
     * @return User
     */
    @Override
    @Select("SELECT id, name, password FROM t_user WHERE id = #{id}")
    User getUserById(@Param("id") Integer id);

    /**
     * Query one user by name and password.
     *
     * @param name User name
     * @param password User password
     * @return User
     */
    @Override
    @Select("SELECT id, name, password FROM t_user WHERE name = #{name} AND password= #{password}")
    User getUserByNamePassword(@Param("name") String name, @Param("password") String password);

    /**
     * Add one user.
     *
     * @param user User Object
     * @return int number
     */
    @Override
    @Insert("INSERT INTO t_user(name, password) VALUES(#{user.name}, #{user.password})")
    int addUser(@Param("user") User user);

    /**
     * Delete one user by ID.
     *
     * @param id User ID
     * @return int Effect num line
     */
    @Override
    @Delete({"DELETE FROM t_user WHERE id = #{id}"})
    int deleteUserById(@Param("id") Integer id);

    /**
     * Update a user.
     *
     * @param user User Object
     * @return int
     */
    @Override
    int updateUser(@Param("user") User user);
}
