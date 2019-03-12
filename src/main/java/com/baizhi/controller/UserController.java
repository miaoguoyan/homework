package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        List<User> list = userService.selectAll();
        request.setAttribute("list",list);
        return "index";
    }
    @RequestMapping("/download")
    public void download(String url,HttpServletRequest request,HttpServletResponse response)throws Exception{
        //获取文件
        File file = new File(request.getSession().getServletContext().getRealPath(url));
        //感觉文件后缀设置响应类型
        String substring = url.substring(url.lastIndexOf("."));
        response.setContentType(request.getSession().getServletContext().getMimeType(substring));
        //设置响应头
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(url.substring(url.lastIndexOf("/")+1), "utf-8"));
        //响应
        FileInputStream inputStream = new FileInputStream(file);
        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }
    @RequestMapping("/add")
    public String add(User user, MultipartFile file, HttpSession session) throws Exception{
        user.setUrl("/img/"+file.getOriginalFilename());
        user.setId(UUID.randomUUID().toString());
        userService.addUser(user);
        String realPath = session.getServletContext().getRealPath("/img");
        file.transferTo(new File(realPath+"\\"+file.getOriginalFilename()));
        return "redirect:/user/findAll";

    }

}
