package com.springmvc.service;

import com.springmvc.pojo.Books;
import com.springmvc.pojo.Categories;
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

    /**
     * 删除指定id图书
     * @param id
     * @return true 删除成功 false 删除失败
     */
    boolean delBookById(int id);

    /**
     * 删除指定数组id图书
     * @param ids
     * @return >0 删除成功 =0 删除失败
     */
    int delBookByIds(int[] ids);

}
