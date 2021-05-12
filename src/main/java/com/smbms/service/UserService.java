package com.smbms.service;

import com.smbms.entity.User;
import com.smbms.util.Page;
import java.sql.SQLException;

public interface UserService {
    User getById(Integer id);
    User login(String userCode,String userPassword);
    int modify(Integer id,String userPassword);
    int add(User user);
    //分页
    Page getPage(String userName, Integer userRole, Integer pageNo, Integer pageSize)throws SQLException;

    User getByCode(String userCode);
}
