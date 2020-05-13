package com.springmvc.service;

import com.springmvc.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 16:49
 */
public interface BookService {

    /**
     * 查询图书信息通过CategoryId
     * @param id ID
     * @return 图书信息
     */
    List<Books> findBookByCid(int id);
}
