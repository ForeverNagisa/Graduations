package com.james.web;


import com.james.bean.Article;
import com.james.service.AriticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
public class ArticleController {
    @Autowired
    AriticleService service;

    // 添加文章
    @RequestMapping("publishingArtice.action")
    public ModelAndView publishingArtice(Article article,@RequestParam(value = "art_img",required = false,defaultValue = "default_pic.png") MultipartFile file, HttpServletRequest request) throws IOException {
        ModelAndView mv = new ModelAndView();

        article.setArt_time(new Date());

        if (!file.isEmpty()){
            String realPath = "/Users/lanou/Desktop/java/javaweb/Graduation/WebContent/upimg/";
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf('.'));
            String newFileName = new Date().getTime() + suffix;
            System.out.println("新文件名：" + newFileName);
            file.transferTo(new File(realPath + File.separator + newFileName));
            article.setArt_img(newFileName);
        }
        boolean isPublish = service.publishingArtice(article);
        if (isPublish){
            request.setAttribute("ariState","发表成功,请刷新网页查看");
            mv.setViewName("Personindex.jsp");
            return mv;
        }
        request.setAttribute("ariState","发表失败");
        mv.setViewName("Personindex.jsp");
        return mv;
    }
}
