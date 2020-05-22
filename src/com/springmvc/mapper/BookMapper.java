package com.springmvc.mapper;

import com.springmvc.pojo.Books;

import com.springmvc.pojo.Categories;
import com.springmvc.provider.DelBook;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 16:36
 */
public interface BookMapper {
    /**
     * 查询图书信息通过CategoryId
     * @param id ID
     * @return 图书信息
     */
    @Select("select * from books where CategoryId = #{cid}")
    List<Books> findBookByCid(@Param("cid")int id);

    /**
     * 根据图书id删除图书信息
     * @param id
     * @return 1为 删除成功 0为 删除失败
     */
    @Delete("delete from books where Id = #{bid}")
    int delBook(@Param("bid")int id);

    /**
     * 根据图书id删除图书信息
     * @param bids
     * @return 删除成功多少条数据
     */
    @DeleteProvider(type = DelBook.class,method = "delBooksByIds")
    int delBooks(@Param("ids") int []bids);

}
