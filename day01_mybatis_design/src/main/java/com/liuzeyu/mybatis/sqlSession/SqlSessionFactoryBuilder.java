package com.liuzeyu.mybatis.sqlSession;

import com.liuzeyu.mybatis.cfg.Configuration;
import com.liuzeyu.mybatis.sqlSession.impl.SqlSessionFactoryImpl;
import com.liuzeyu.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    /**
     * 根据字节输入流构建一个工厂
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(is);
        return  new SqlSessionFactoryImpl(configuration);
    }
}
