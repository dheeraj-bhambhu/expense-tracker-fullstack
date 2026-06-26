package com.dheeraj.expensetracker.service;

import com.dheeraj.expensetracker.entity.Category;
import com.dheeraj.expensetracker.repository.CategoryRepository;
import com.dheeraj.expensetracker.service.CategoryService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void testCreateCategory() {

        Category category = new Category();
        category.setId(1L);
        category.setName("Food");

        when(categoryRepository.save(any(Category.class)))
                .thenReturn(category);

        Category response = categoryService.addCategory(category);

        assertEquals("Food", response.getName());

        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    void testGetAllCategory() {

        Category category1 = new Category();
        category1.setId(1L);
        category1.setName("Food");

        Category category2 = new Category();
        category2.setId(2L);
        category2.setName("Shopping");

        List<Category> categories = List.of(category1, category2);

        when(categoryRepository.findAll())
                .thenReturn(categories);

        List<Category> response = categoryService.getAllCategory();

        assertEquals(2, response.size());
        assertEquals("Food", response.get(0).getName());
        assertEquals("Shopping", response.get(1).getName());

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testGetCategoryById() {

        Category category = new Category();
        category.setId(1L);
        category.setName("Food");

        when(categoryRepository.findById(1L))
                .thenReturn(Optional.of(category));

        Category response = categoryService.getCategoryById(1L);

        assertEquals(1L, response.getId());
        assertEquals("Food", response.getName());

        verify(categoryRepository, times(1)).findById(1L);
    }
    @Test
    void testDeleteCategory() {

        // Arrange
        Category category = new Category();
        category.setId(1L);
        category.setName("Food");

        when(categoryRepository.findById(1L))
                .thenReturn(Optional.of(category));

        // Act
        categoryService.deleteCategory(1L);

        // Verify
        verify(categoryRepository, times(1)).findById(1L);
        verify(categoryRepository, times(1)).delete(category);
    }
}