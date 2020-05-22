package com.springmvc.test;

import com.springmvc.mapper.BookMapper;
import com.springmvc.mapper.CategoriesMapper;
import com.springmvc.mapper.UserMapper;
import com.springmvc.pojo.Books;
import com.springmvc.pojo.Categories;
import com.springmvc.provider.DelBook;
import com.springmvc.service.CategorieService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 12:30
 */
public class SelectTest {

    ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    CategoriesMapper categoriesMapper=(CategoriesMapper) context.getBean("categoriesMapper");
    CategorieService categorieService=(CategorieService) context.getBean("catrgoriesService");
    BookMapper bookMapper=(BookMapper) context.getBean("bookMapper");
    UserMapper userMapper=(UserMapper) context.getBean("userMapper");
    @org.junit.Test
    public void findC(){
        List<Categories> categoriesList=categoriesMapper.findCategories();
        List<Categories> categoriesList2=categorieService.findCategories();
        for (Categories c:categoriesList2) {
            System.out.println(c);
        }
    }
    @Test
    public void findB(){
        List<Books> booksList=bookMapper.findBookByCid(1);
        for (Books b:booksList) {
            System.out.println(b);
        }
    }
    @Test
    public void testA(){
        int a=userMapper.dologin("gou","123456");
        System.out.println(a);
    }
    @Test
    public void del(){
        int[] id={6090,6088};
        for (int i: id
             ) {
            System.out.println(i);
        }
        int updates = bookMapper.delBooks(id);
        System.out.println("删除了"+updates+"数据");
    }
    @Test
    public void selectCid(){
        System.out.println(categorieService.selectCidByBookId(6103));
    }
}
