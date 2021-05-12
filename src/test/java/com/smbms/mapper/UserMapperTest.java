package com.smbms.mapper;

import com.smbms.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getPageList() {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> pageList = userMapper.getPageList(null, null, 0, 5);
        for (User user : pageList) {
            System.out.println(user);
        }
    }
}