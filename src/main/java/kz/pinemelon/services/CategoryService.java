package kz.pinemelon.services;

import kz.pinemelon.entities.Category;
import kz.pinemelon.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category create(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> listCategories(){
        return categoryRepository.findAll();
    }

    public Category update(Category old, Category temp){
        // refresh values of old by values of temp
        BeanUtils.copyProperties(temp, old, "id");
        return categoryRepository.save(old);
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }
}
