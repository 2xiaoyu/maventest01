package com.smbms.controller;

import com.smbms.entity.Role;
import com.smbms.entity.User;
import com.smbms.service.RoleService;
import com.smbms.service.UserService;
import com.smbms.util.Constains;
import com.smbms.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    //分页
    @RequestMapping("/Pagination")
    public String Pagination(String queryname,
                             @RequestParam(defaultValue = "0") Integer queryUserRole,
                             @RequestParam(defaultValue = "0") Integer currentPageNo,
                             @RequestParam(defaultValue = "5") Integer pageSize,
                             Model model) throws SQLException {
        Page page = userService.getPage(queryname, queryUserRole,currentPageNo, pageSize);
        List<Role> RoleList = roleService.getall();
        //回显
        model.addAttribute("queryUserRole",queryUserRole);
        model.addAttribute("queryname",queryname);

        model.addAttribute("page",page);
        model.addAttribute("roleList",RoleList);
        return "userlist";
    }

    @RequestMapping("/login")
    public String login(String userCode,String userPassword,HttpSession session){
        User user = userService.login(userCode, userPassword);
        session.setAttribute(Constains.USER_SESSION,user);
        if (user!=null){
            return "redirect:frame";
        }
        return "../login";
    }
    @RequestMapping("/frame")
    public String login1(){
        return "frame";
    }
    //改密码
    @RequestMapping("/user.do")
    @ResponseBody
    public String login1(String oldpassword, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user.getUserPassword().equals(oldpassword)){
            return "true";
        }else {
            return "false";
        }
    }
    //改密码
    @RequestMapping("/modify")
    public String modify(String newpassword,HttpSession session){
        User user = (User) session.getAttribute(Constains.USER_SESSION);
        int modify = userService.modify(user.getId(), newpassword);
        if(modify>0){
            return "frame";
        }else {
            return "login";
        }
    }
    //判断注册用户的用户编码是否重复
    @RequestMapping("/Judgmentcode")
    @ResponseBody
    public String Judgmentcode(String userCode){
        User user=userService.getByCode(userCode);
        if(user!=null){
            return "false";
        }else {
            return "true";
        }
    }
    //查看
    //判断注册用户的用户编码是否重复
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") Integer id,Model model){
        User user=userService.getById(id);
        model.addAttribute("user",user);
       return "userview";
    }
    //添加用户
    @ResponseBody
    @RequestMapping("/add")
    public String modify(User user, HttpSession session, HttpServletRequest request,
                         @RequestParam(value = "img",required = false) MultipartFile file) throws Exception {
        String realPath = request.getServletContext().getRealPath("images/");
        file.transferTo(new File(realPath+File.separator+file.getOriginalFilename()));
        user.setIdPicPath("images/"+file.getOriginalFilename());
        User attribute = (User) session.getAttribute(Constains.USER_SESSION);
        user.setCreatedBy(attribute.getId());
        user.setCreationDate(new Date());
        int add = userService.add(user);
        if(add>0){
            return "true";
        }else {
            return "false";
        }
    }
}
