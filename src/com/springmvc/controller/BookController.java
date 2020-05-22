package com.springmvc.controller;

import com.springmvc.pojo.Books;
import com.springmvc.pojo.Categories;
import com.springmvc.service.BookService;
import com.springmvc.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private CategorieService categorieService;

    /**
     * 通过cid查询出对应的图书信息
     * @param cid
     * @param cname
     * @return list对象的图书信息
     */
    public Map<String,Object> doSelectByCid(int cid,String cname){
        Map<String,Object> map=new HashMap<String, Object>();
        List<Books> booksList=bookService.findBookByCid(cid);
        map.put("Cname",cname);
        map.put("bookList",booksList);
        return map;
    }

    /**
     * RESTful风格查询cid对应的图书信息
     * @param cid
     * @return 将图书结果集返回到Session中，并跳转到处理界面
     */
    @RequestMapping(value="/cid/{id}/name/{Cname}",method= RequestMethod.GET)
    public String selectBook(@PathVariable("id") String cid, @PathVariable("Cname")String name, HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession();
        Map<String,Object> map=doSelectByCid(Integer.parseInt(cid),name);
        session.setAttribute("info_book",map);
        return "book_info";
//        return "index";
    }

    /**
     * 删除后重新给session中的booklist重新赋值
     * @param session
     * @param categories
     */
    public void delSession(HttpSession session,Categories categories){
        //通过对应的Cid与Cname 当删除后 重新给session赋值
        Map<String,Object> dataMap=doSelectByCid((int)categories.getId(),categories.getName());
        session.removeAttribute("info_book");
        session.setAttribute("info_book",dataMap);
    }

    @GetMapping({"bookDelThis","bookDelChoose"})
    public String toIndex(){
        return "index";
    }

    @PostMapping("bookDelThis")
    @ResponseBody
    public Map<String,String> delThis(String bookId,HttpSession session){
        Map<String,String> resultMap = new HashMap<String, String>();
        int BookId_i=Integer.parseInt(bookId);
        //得到categories中的cid与cname
        Categories categories=categorieService.selectCidByBookId(BookId_i);
        if(bookService.delBookById(BookId_i)){
            //重新赋值Session中的booklist
            delSession(session,categories);
            resultMap.put("result","1");
        }else{
            resultMap.put("result","0");
        }
        return resultMap;
    }

    @PostMapping("bookDelChoose")
    @ResponseBody
    public Map<String,String> delChoose(@RequestParam(value = "bookIds[]") String[] bookIds,HttpSession session){
        Map<String,String> resultMap = new HashMap<String, String>();
        int[] intBids = new int[bookIds.length];
        //将String数组转换成int数组
        for (int i = 0; i < bookIds.length; i++) {
            intBids[i]=Integer.parseInt(bookIds[i]);
            System.out.println(bookIds[i]);
        }
        //得到categories中的cid与cname
        Categories categories=categorieService.selectCidByBookId(intBids[0]);
        System.out.println(categories.toString());
        int flag = bookService.delBookByIds(intBids);
        if(flag>0){
            //重新赋值Session中的booklist
            delSession(session,categories);
            resultMap.put("result","1");
            resultMap.put("updates",String.valueOf(flag));
        }else{
            resultMap.put("result","0");
            resultMap.put("updates","0");
        }
        return resultMap;
    }


}
