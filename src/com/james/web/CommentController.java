package com.james.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.james.bean.Comments;
import com.james.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService service;

    // 评论请求
    @RequestMapping(value = "pushArticleComment.action")
    public String pushArticleComment(Comments comments)  {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
        String dates = sdf.format(date);
        comments.setDate(dates);
        System.out.println(comments);
        service.insertComment(comments);
        return "selectComment.action";
    }

    @RequestMapping("selectComment.action")
    public String selectComment(HttpServletRequest request){
        int i = Integer.parseInt(request.getParameter("article_id"));
        List<Comments> comments = service.selectPersonArticle(i);
        request.getSession().setAttribute("comments",comments);
        return "redirect:/article.jsp";
    }


    @RequestMapping(value = "selectPersonArticle.action",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectPersonArticle(String id){
        int i = Integer.parseInt(id);
        List<Comments> comments = service.selectPersonArticle(i);

        String s = JSON.toJSONString(comments);

        return s;
    }
}
