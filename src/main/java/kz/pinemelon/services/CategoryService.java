package kz.pinemelon.services;

import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Component;
import kz.pinemelon.entities.Product;
import kz.pinemelon.form.CategoryForm;
import kz.pinemelon.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category create(CategoryForm categoryForm){
        Category category = new Category();
        category.setName(categoryForm.getName());
        category.setDescription(categoryForm.getDescription());
        category.setImage(categoryForm.getImage());
        category.setEnabled(categoryForm.isEnabled());
        if (categoryForm.getCategory_id() != null){
            if(categoryRepository.existsById(categoryForm.getCategory_id())){
                Category parentCategory = categoryRepository.getById(categoryForm.getCategory_id());
                category.setCategory(parentCategory);
            }
        }
        category.setCreationDate(LocalDateTime.now());
        category.setUpdateDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public Category update(Category category, Category temp){
        // refresh values of old by values of temp
        BeanUtils.copyProperties(temp, category, "id");
        category.setUpdateDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }

    private List<Category> getCategories(Category category){
        List<Category> categories = new ArrayList<>();
        for (Component component: category.getComponents()) {
            if (component instanceof Category){
                categories.add((Category) component);
            }
        }
        return categories;
    }

    public List<Category> list(Category category){
        if (category == null)
            return categoryRepository.findAll();
        else if (categoryRepository.existsById(category.getId())){
            return this.getCategories(category);
        }
        return categoryRepository.findAll();
    }
}
