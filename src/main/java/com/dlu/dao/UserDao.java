package com.dlu.dao;

import com.dlu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    /**用户名和密码都正确的情况下查询
     * @param name
     * @param pwd
     * @return: user
     * */
    User findUserByNameAndPwd(String name,String pwd);
}
