package com.liuzeyu.dao;
import com.liuzeyu.domain.User;
import java.util.List;

public interface IUserDao {

    public List<User> findAll();
}
