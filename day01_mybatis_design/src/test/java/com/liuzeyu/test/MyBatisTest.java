package com.liuzeyu.test;


import com.liuzeyu.dao.IUserDao;
import com.liuzeyu.domain.User;
import com.liuzeyu.mybatis.sqlSession.SqlSession;
import com.liuzeyu.mybatis.sqlSession.SqlSessionFactory;
import com.liuzeyu.mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    /**
     * mybatis入门案例测试
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //1.读取配置文件SqlMapConfig.xml
        InputStream is = MyBatisTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        //3.使用factory创建SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSessionFactory创建dao层接口的动态代理对象
        IUserDao dao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users = dao.findAll();
        //6.遍历输出结果
        for (User user : users) {
            System.out.println(user);
        }
        //释放资源
        is.close();
        session.close();
    }
}
