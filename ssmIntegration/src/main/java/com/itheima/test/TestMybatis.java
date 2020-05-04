package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        //读取配置文件
        //InputStreamResource in = new InputStreamResource("SqlMapConfig.xml");
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //创建dao的代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        //执行方法
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        //若有事务，提交事务
        session.commit();
        //释放资源
        session.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //创建dao的代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        //执行方法
        Account account = new Account();
        account.setName("李瑶");
        account.setMoney(100d);
        dao.saveAccount(account);

        //若有事务，提交事务
        session.commit();
        //释放资源
        session.close();
        System.out.println("保存成功！");
    }
}
