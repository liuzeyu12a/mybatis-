package com.liuzeyu.mybatis.sqlSession.impl;

import com.liuzeyu.mybatis.cfg.Configuration;
import com.liuzeyu.mybatis.sqlSession.SqlSession;
import com.liuzeyu.mybatis.sqlSession.SqlSessionFactory;

public class SqlSessionFactoryImpl implements SqlSessionFactory {
    private Configuration configuration;

    public SqlSessionFactoryImpl(Configuration configuration){
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new SqlSessionImpl(configuration);
    }
}
