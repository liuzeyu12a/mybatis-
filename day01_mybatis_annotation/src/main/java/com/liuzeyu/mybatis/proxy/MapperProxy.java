package com.liuzeyu.mybatis.proxy;

import com.liuzeyu.mybatis.cfg.Mapper;
import com.liuzeyu.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler{
    private Map<String,Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 使用方法进行增强，在增强过程中调用selectList
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName  = method.getName();
        //2.获取方法名所在的类名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className+"."+methodName ;
        //4.获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        if( mapper == null){
            throw new IllegalArgumentException("传入的参数有误...");
        }
        return new Executor().selectList(mapper,conn);
    }
}
