package com.yqw.spring.hibernate.jpa.test;


import com.yqw.spring.hibernate.jpa.dao.UsersDao;
import com.yqw.spring.hibernate.jpa.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersDaoImplTest {

    @Autowired
    private UsersDao usersDao;


    /**
     * 添加用户
     */
    @Test
    @Transactional// 在测试类对于事务提交方式默认的是回滚。
    @Rollback(false)//取消自动回滚
    public void testInsertUsers() {
        Users users = new Users();
        users.setUserage(24);
        users.setUsername("王小丽");
        this.usersDao.insertUsers(users);
    }

    /**
     * 更新用户
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testUpdateUsers() {
        Users users = new Users();
        users.setUserid(5);
        users.setUserage(22);
        users.setUsername("王五");
        this.usersDao.updateUsers(users);
    }

    /**
     * 根据userid查询用户
     */
    @Test
    public void testSelectUsersById() {
        Users users = this.usersDao.selectUsersById(4);
        System.out.println(users);
    }

    /**
     * 删除用户
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteUsers() {
        Users users = new Users();
        users.setUserid(4);
        this.usersDao.deleteUsers(users);
    }

    /**
     * HQL测试
     */
    @Test
    @Transactional
    public void testSelectUserByName() {
        List<Users> list = this.usersDao.selectUserByName("王五");
        for (Users users : list) {
            System.out.println(users);
        }
    }

    /**
     * SQL测试
     */
    @Test
    @Transactional
    public void testSelectUserByNameUseSQL() {
        List<Users> list = this.usersDao.selectUserByNameUseSQL("王五");
        for (Users users : list) {
            System.out.println(users);
        }
    }

    /**
     * Criteria测试
     */
    @Test
    @Transactional
    public void testSelectUserByNameUseCriteria() {
        List<Users> list = this.usersDao.selectUserByNameUseCriteria("王五");
        for (Users users : list) {
            System.out.println(users);
        }
    }
}
