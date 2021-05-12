package com.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.smbms.entity.Role;
import com.smbms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    //遍历角色
    @RequestMapping("/rolegetall")
    @ResponseBody
    public Object rolegetall(){
        List<Role> getall = roleService.getall();
        return getall;
    }
}
