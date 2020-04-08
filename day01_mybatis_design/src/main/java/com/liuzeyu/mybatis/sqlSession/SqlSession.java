package com.liuzeyu.mybatis.sqlSession;


public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 关闭session
     */
    public void close();
}
