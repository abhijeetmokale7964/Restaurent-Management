package com.abhi.restaurant.service;


import java.util.List;

import com.abhi.restaurant.model.Category;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    void deleteCategory(Long id);
}