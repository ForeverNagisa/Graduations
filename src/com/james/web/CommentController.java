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
    @RequestMapping(value = "pushArticleComment.action",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String testAjaxJsonArray( String json, HttpServletRequest request) throws UnsupportedEncodingException {
//        String decode = URLDecoder.decode(json, "UTF-8");
//        System.out.println(decode);
        System.out.println(json);
        Comments comments = JSON.toJavaObject(JSON.parseObject(json), Comments.class);
        System.out.println(comments);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
            String dates = sdf.format(date);
            comments.setDate(dates);
        System.out.println(dates);
            service.insertComment(comments);


//        Comments comments = new Comments();
//        comments.setComm_name(request.getParameter("comm_name"));
//        System.out.println(request.getParameter("comm_name"));
//        comments.setDate(dates);
//        comments.setArticle_id(Integer.parseInt(request.getParameter("art_id")));
//        System.out.println(request.getParameter("art_id"));
//        comments.setPerson_id(Integer.parseInt(request.getParameter("person_id")));
//        comments.setPerson_name(request.getParameter("per"));
//        System.out.println(request.getParameter("per"));
//        System.out.println(comments);



        return "成功";
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
