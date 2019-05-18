package com.yqw.boot.ehcache;


import com.yqw.boot.ehcache.domain.User;
import com.yqw.boot.ehcache.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 对业务层 UsersService进行测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void testFindUserById() {
        //第一次查询
        System.out.println(usersService.findUserById(1));

        //第二次查询
        System.out.println(usersService.findUserById(1));
    }


    @Test
    public void testFindUserByPage() {
        Pageable pageable = new PageRequest(0, 2);
        //第一次查询
        System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());

        //第二次查询
        System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());

        //第三次查询
        pageable = new PageRequest(1, 2);
        System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
    }

    @Test
    public void testFindAll() {
        //第一次查询
        System.out.println(this.usersService.findUserAll().size());

        User users = new User();
        users.setAddress("南京");
        users.setAge(43);
        users.setName("朱七");
        this.usersService.saveUsers(users);//保存的生活清空缓存

        //第二次查询
        System.out.println(this.usersService.findUserAll().size());
    }
}
