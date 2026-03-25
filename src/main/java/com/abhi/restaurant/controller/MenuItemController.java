package com.abhi.restaurant.controller;

import com.abhi.restaurant.model.MenuItem;
import com.abhi.restaurant.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuItemController {

    private final MenuItemService service;

    // create menu item
    @PostMapping
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem item) {

        log.info("API call to create menu item: {}", item.getName());

        return ResponseEntity.ok(service.createMenuItem(item));
    }

    // get all menu items
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {

        log.info("API call to fetch all menu items");

        return ResponseEntity.ok(service.getAllMenuItems());
    }

    // get menu item by id
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable Long id) {

        log.info("API call to fetch menu item id: {}", id);

        return ResponseEntity.of(
                java.util.Optional.ofNullable(service.getMenuItemById(id))
        );
    }

    // update menu item
    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id,
                                                   @RequestBody MenuItem item) {

        log.info("API call to update menu item id: {}", id);

        return ResponseEntity.ok(service.updateMenuItem(id, item));
    }

    // delete menu item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {

        log.warn("API call to delete menu item id: {}", id);

        service.deleteMenuItem(id);

        return ResponseEntity.noContent().build();
    }
}