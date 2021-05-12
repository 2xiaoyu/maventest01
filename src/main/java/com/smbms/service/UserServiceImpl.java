package com.smbms.service;

import com.smbms.entity.User;
import com.smbms.mapper.UserMapper;
import com.smbms.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public User login(String userCode, String userPassword) {
        return userMapper.login(userCode,userPassword);
    }

    @Override
    public int modify(Integer id, String userPassword) {
        return userMapper.modify(id,userPassword);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }


    public Page getPage(String userName,Integer userRole,Integer pageNo, Integer pageSize) throws SQLException {
        Page page=new Page();
        //1.确定每页大小
        pageNo=pageNo<0?0:pageNo;
        pageSize=pageSize<=0?1:pageSize;

        //2.确定总页数
        int totalCount=userMapper.getTotalCount(userName,userRole);
        int totalPageCount
                =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        //对页码进行兼容性处理
        pageNo=pageNo>totalPageCount?totalPageCount:pageNo;
        //3.sql获取当前页的数据

        List<User> list=userMapper.getPageList(userName,userRole,pageNo,pageSize);
        //4.返回初始化之后的Page对象
        if(pageNo==0){
            page.setCurrentPageNo(pageNo+1);
        }else {
            page.setCurrentPageNo(pageNo);
        }
        page.setPageSize(pageSize);
        page.setTotalCount(totalCount);
        page.setTotalPageCount(totalPageCount);
        page.setUserList(list);
        return page;
    }

    @Override
    public User getByCode(String userCode) {
        return userMapper.getByCode(userCode);
    }
}
