package com.liuzeyu.dao;
import com.liuzeyu.domain.User;
import com.liuzeyu.mybatis.annotation.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from user")
    public List<User> findAll();
}
