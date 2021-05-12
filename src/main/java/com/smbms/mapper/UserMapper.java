package com.smbms.mapper;

import com.smbms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User getById(Integer id);
    User login(@Param("userCode") String userCode,
               @Param("userPassword") String userPassword);
    int modify(@Param("id") Integer id,
               @Param("userPassword") String userPassword);
    int add(User user);
    List<User> getall();
    int getTotalCount(@Param("userName") String userName,
                      @Param("userRole") Integer userRole );//查看用户总数

    List<User> getPageList(@Param("userName") String userName,
                     @Param("userRole") Integer userRole,
                     @Param("pageNo") Integer pageNo,
                     @Param("pageSize") Integer pageSize);

    User getByCode(String userCode);
}
