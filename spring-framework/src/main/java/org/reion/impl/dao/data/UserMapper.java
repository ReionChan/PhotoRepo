package org.reion.impl.dao.data;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.reion.impl.domain.User;

import java.util.List;

/**
 * User Mapper Object.
 *
 * @author Reion
 * @version 1.0
 * @date 2018-08-23 01:03
 **/
public interface UserMapper {
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
    @Select("SELECT id, name, password FROM t_user WHERE id = #{id}")
    User getUserById(@Param("id") Integer id);

    /**
     * Query one user by name and password.
     *
     * @author Reion
     * @param name User name
     * @param password User password
     * @return User
     */
    @Select("SELECT id, name, password FROM t_user WHERE name = #{name} AND password= #{password}")
    User getUserByNamePassword(@Param("name") String name, @Param("password") String password);

    /**
     * Add one user.
     *
     * @author Reion
     * @param user User Object
     */
    @Insert("INSERT INTO t_user(name, password) VALUES(#{user.name}, #{user.password})")
    void addUser(@Param("user") User user);

    /**
     * Delete one user by ID.
     *
     * @author Reion
     * @param id User ID
     */
    @Delete({"DELETE FROM t_user WHERE id = #{id}"})
    void deleteUserById(@Param("id") Integer id);

    /**
     * Update a user.
     *
     * @author Reion
     * @param user User Object
     * @return int
     */
    int updateUser(@Param("user") User user);
}
