package com.james.web;

import com.james.bean.Article;
import com.james.bean.Person;
import com.james.service.AriticleService;
import com.james.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService service;
    @Autowired
    private AriticleService ariticleService;

    // 用户登录请求
    @RequestMapping("loginPerson.action")
    public String loginPerson(Person person, ModelMap model, HttpSession session){

        Person persons = service.loginPerson(person);

        if (persons != null){
            List<Article> sperArt = ariticleService.selectAllAriticle(persons.getId());
            String personImg = service.getPersonImg(person);
            persons.setHeadimg(personImg);
            System.out.println(persons);
            session.setAttribute("persons",persons);
            session.setAttribute("sperArt",sperArt);
            return "redirect:Personindex.jsp";
        }else {
            model.addAttribute("errormsg","用户名或密码错误");
            return "index.jsp";
        }
    }

    // 用户注册请求
    @RequestMapping("registerPerson.action")
    public String registerPerson(Person person, ModelMap model){
        boolean isRegister = service.registerPerson(person);
        if (isRegister){
            model.addAttribute("errormsg","恭喜你 注册成功!");
            return "index.jsp";
        }else {
            model.addAttribute("errormsg","昵称已被占用!");
            return "index.jsp";
        }
    }

    // 用户注销请求
    @RequestMapping("logonlogon.action")
    public String logonlogon(HttpSession session){
        session.invalidate();
        return "index.jsp";
    }

    // 修改个人信息
    @RequestMapping("updatePersonInfo.action")
    public String updatePersonInfo(Person person,ModelMap model,HttpSession session){
        service.updatePersonInfo(person);
        model.addAttribute("errormsg","修改成功! 请重新登录");
        return "index.jsp";
    }

    // 上传头像
    @RequestMapping("upPersonimgs.action")
    public ModelAndView upPersonimgs(@RequestParam("file") MultipartFile file, HttpServletRequest request, Integer id) throws IOException {
        ModelAndView mv = new ModelAndView();

        if (!file.isEmpty()){
            String realPath = request.getServletContext().getRealPath("/upimg/");
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf('.'));
            String newFileName = new Date().getTime() + suffix;
            // 把名字保存到数据库中
            service.upPersonimgs(newFileName,id);
            file.transferTo(new File(realPath + File.separator + newFileName));
            request.getSession().setAttribute("imgpath",newFileName);
            mv.setViewName("redirect:/Personindex.jsp");
            return mv;
        }
        mv.setViewName("redirect:/Personindex.jsp");
        return mv;

    }
}
