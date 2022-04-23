package kz.pinemelon.services;

import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Component;
import kz.pinemelon.entities.Product;
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

    public Category create(Category category){
        category.setCreationDate(LocalDateTime.now());
        category.setUpdateDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public List<Category> list(){
        return categoryRepository.findAll();
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

    public List<Category> listByCategory(Category category){
        if (categoryRepository.existsById(category.getId())){
            return this.getCategories(category);
        }
        return null;
    }
}
