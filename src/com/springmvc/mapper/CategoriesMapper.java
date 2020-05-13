package com.springmvc.mapper;

import com.springmvc.pojo.Categories;
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
}
