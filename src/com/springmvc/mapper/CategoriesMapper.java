package com.springmvc.mapper;

import com.springmvc.pojo.Categories;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 12:06
 */
public interface CategoriesMapper {

    /**
     * 查找所有种类的名字
     * @return
     */
    @Select("select * from categories")
    List<Categories> findCategories();

    /**
     * 通过bookId得到对应的Cid
     * @param bookId
     * @return Cid
     */
    @Select("select c.Id,c.Name from categories as c where c.id=(select CategoryId from books where books.id=#{bid})")
    Categories selectCidByBookId(@Param("bid")int bookId);
}
