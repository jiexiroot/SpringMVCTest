package com.springmvc.service;

import com.springmvc.pojo.Categories;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 14:04
 */
public interface CategorieService {
    public List<Categories> findCategories();
    /**
     * 通过bookId得到对应的Cid,Cname
     * @param bookId
     * @return Cid,Cname
     */
    Categories selectCidByBookId(int bookId);
}
