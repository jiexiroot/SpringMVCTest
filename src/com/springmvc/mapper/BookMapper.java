package com.springmvc.mapper;

import com.springmvc.pojo.Books;
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
}
