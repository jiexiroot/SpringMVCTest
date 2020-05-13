package com.springmvc.service;

import com.springmvc.pojo.Categories;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 14:04
 */
public interface CategorieService {
    public List<Categories> findCategories();

}
