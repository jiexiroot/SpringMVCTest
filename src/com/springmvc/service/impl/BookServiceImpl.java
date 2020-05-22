package com.springmvc.service.impl;

import com.springmvc.mapper.BookMapper;
import com.springmvc.pojo.Books;
import com.springmvc.pojo.Categories;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 16:50
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Books> findBookByCid(int id) {
        return bookMapper.findBookByCid(id);
    }

    @Override
    public boolean delBookById(int id) {
        return bookMapper.delBook(id)!=0?true:false;
    }

    @Override
    public int delBookByIds(int[] ids) {
        return bookMapper.delBooks(ids);
    }


}
