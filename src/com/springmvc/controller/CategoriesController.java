package com.springmvc.controller;

import com.springmvc.pojo.Books;
import com.springmvc.pojo.Categories;
import com.springmvc.pojo.User2;
import com.springmvc.service.CategorieService;
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
 * @Date 2020-05-13 14:06
 */
@Controller
public class CategoriesController {

    @Autowired
    private CategorieService categorieService;

    /**
     * 请求映射ajax中的selectfromC
     * @param request
     * @param response
     * @return result 为 查询结果flag slc为结果集
     */
    @RequestMapping("/selectfromC")
    @ResponseBody
    public Map<String,Object> ajaxSelect(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        List<Categories> categoriesList=categorieService.findCategories();
        if(categoriesList!=null){
            HttpSession session =request.getSession();
            session.setAttribute("s_L_c",categoriesList);
            resultMap.put("result","1");
            resultMap.put("slc",categoriesList);
        }else{
            resultMap.put("result","0");
            resultMap.put("slc",null);
        }

        return resultMap;
    }

}
