package com.springmvc.service.impl;

import com.springmvc.mapper.CategoriesMapper;
import com.springmvc.pojo.Categories;
import com.springmvc.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GOU
 * @Date 2020-05-13 14:04
 */
@Service("catrgoriesService")
public class CatrgorieServiceImpl implements CategorieService {
    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public List<Categories> findCategories(){
        return categoriesMapper.findCategories();
    }

    @Override
    public Categories selectCidByBookId(int bookId) {
        return categoriesMapper.selectCidByBookId(bookId);
    }
}
