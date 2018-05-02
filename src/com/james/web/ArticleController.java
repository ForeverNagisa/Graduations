package com.james.web;


import com.james.bean.Article;
import com.james.service.AriticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    AriticleService service;

    // 添加文章
    @RequestMapping("publishingArtice.action")
    public ModelAndView publishingArtice(@RequestParam(value = "art_img",required = false,defaultValue = "default_pic.png") MultipartFile file,
                                         HttpServletRequest request) throws IOException {
        ModelAndView mv = new ModelAndView();
        Article article = new Article();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String dates = sdf.format(date);
        article.setArt_time(dates);
        article.setArt_title(request.getParameter("art_title"));
        article.setArt_content(request.getParameter("art_content"));
        article.setPerson_id(Integer.parseInt(request.getParameter("person_id")));

        if (!file.isEmpty()){
            String realPath = request.getServletContext().getRealPath("/upimg/");
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf('.'));
            String newFileName = new Date().getTime() + suffix;
            file.transferTo(new File(realPath + File.separator + newFileName));
            article.setArt_img(newFileName);
        }
        boolean isPublish = service.publishingArtice(article);
        if (isPublish){
            request.setAttribute("ariState","发表成功,请刷新网页查看");

            request.getSession().setAttribute("person_id",article.getPerson_id());
            mv.setViewName("redirect:/success.jsp");
            return mv;
        }
        request.setAttribute("ariState","发表失败");
        mv.setViewName("Personindex.jsp");
        return mv;
    }

    // 查询个人用户的id
    @RequestMapping("selectAllAriticle.action")
    public ModelAndView selectAllAriticle( Integer id, HttpSession session){
        System.out.println(id);
        ModelAndView mv = new ModelAndView();
        List<Article> sperArt = service.selectAllAriticle(id);
        session.setAttribute("sperArt",sperArt);
        mv.setViewName("redirect:/Personindex.jsp");
        return mv;
    }
}
