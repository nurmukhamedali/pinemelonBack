package kz.pinemelon.services;

import kz.pinemelon.entities.CartItem;
import kz.pinemelon.entities.Category;
import kz.pinemelon.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<Category> listCategories(){
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

}
