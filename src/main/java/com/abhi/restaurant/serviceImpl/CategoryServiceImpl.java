package com.abhi.restaurant.serviceImpl;

import com.abhi.restaurant.model.Category;
import com.abhi.restaurant.repository.CategoryRepository;
import com.abhi.restaurant.service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        log.info("Creating category: {}", category.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        log.info("Fetching all categories");
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void deleteCategory(Long id) {
        log.warn("Deleting category id: {}", id);
        categoryRepository.deleteById(id);
    }
}