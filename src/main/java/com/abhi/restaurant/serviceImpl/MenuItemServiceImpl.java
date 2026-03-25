package com.abhi.restaurant.serviceImpl;

import com.abhi.restaurant.model.Category;
import com.abhi.restaurant.model.MenuItem;
import com.abhi.restaurant.repository.CategoryRepository;
import com.abhi.restaurant.repository.MenuItemRepository;
import com.abhi.restaurant.service.MenuItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {

        log.info("Creating menu item: {}", menuItem.getName());

        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        log.info("Fetching all menu items");
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    @Override
    public MenuItem updateMenuItem(Long id, MenuItem updatedItem) {

        MenuItem item = getMenuItemById(id);

        item.setName(updatedItem.getName());
        item.setPrice(updatedItem.getPrice());
        item.setCategory(updatedItem.getCategory());

        log.info("Updating menu item id: {}", id);

        return menuItemRepository.save(item);
    }

    @Override
    public void deleteMenuItem(Long id) {

        log.warn("Deleting menu item id: {}", id);

        menuItemRepository.deleteById(id);
    }
}