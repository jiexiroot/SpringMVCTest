package com.springmvc.controller;

import com.springmvc.pojo.Books;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GOU
 * @Date 2020-05-13 16:51
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    /**
     * RESTful风格查询cid对应的图书信息
     * @param cid
     * @return 将图书结果集返回到Session中，并跳转到处理界面
     */
    @RequestMapping(value="/cid/{id}/name/{Cname}",method= RequestMethod.GET)
    public String selectBook(@PathVariable("id") String cid, @PathVariable("Cname")String name, HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession();
        Map<String,Object> map=new HashMap<String, Object>();
        List<Books> booksList=bookService.findBookByCid(Integer.parseInt(cid));
        map.put("Cname",name);
        map.put("bookList",booksList);
        session.setAttribute("info_book",map);
        return "book_info";
    }
}
