package com.liuzeyu.mybatis.sqlSession.impl;

import com.liuzeyu.mybatis.cfg.Configuration;
import com.liuzeyu.mybatis.cfg.Mapper;
import com.liuzeyu.mybatis.proxy.MapperProxy;
import com.liuzeyu.mybatis.sqlSession.SqlSession;
import com.liuzeyu.mybatis.utils.DateSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class SqlSessionImpl implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        conn = DateSourceUtil.getConnection(cfg);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn));

    }

    public void close() {
        if(conn != null){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
