package kz.pinemelon.services;

import kz.pinemelon.domain.Category;
import kz.pinemelon.domain.Product;
import kz.pinemelon.form.CategoryForm;
import kz.pinemelon.form.ProductForm;
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

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category create(CategoryForm categoryForm){
        Category category = new Category();
        category.setName(categoryForm.getName());
        category.setImage(categoryForm.getImage());
        return categoryRepository.save(category);
    }

    public Category update(Category oldCategory, CategoryForm category){
        oldCategory.setName(category.getName());
        oldCategory.setImage(category.getImage());
        return categoryRepository.save(oldCategory);
    }

    public void delete(Category category){
        categoryRepository.delete(category);
    }

    public CategoryForm getDetails(Category category){
        CategoryForm c = new CategoryForm();
        c.setId(category.getId());
        c.setName(category.getName());
        c.setImage(category.getImage());
        return c;
    }

    public CategoryForm createDetails(CategoryForm category){
        return getDetails(create(category));
    }

    public CategoryForm updateDetails(Category oldCategory, CategoryForm category){
        return getDetails(update(oldCategory, category));
    }

    public List<CategoryForm> findAllDetails(){
        List<CategoryForm> forms = new ArrayList<>();
        for (Category category: findAll()) {
            forms.add(getDetails(category));
        }
        return forms;
    }

    public Category get(Long id){
        return categoryRepository.getById(id);
    }

    public boolean exist(Long id) {
        return categoryRepository.existsById(id);
    }
}
