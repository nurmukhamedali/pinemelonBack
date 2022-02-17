package kz.pinemelon.controller;

import kz.pinemelon.entities.Category;
import kz.pinemelon.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public Category get(@PathVariable("id") Category category){
        return category;
    }

    @CrossOrigin(origins="http://localhost:8080")
    @PostMapping
    public Category create(Category category){
        return categoryRepository.save(category);
    }

    @PutMapping("{id}")
    public Category update(
            @PathVariable("id") Category categoryFromDB,
            @RequestBody Category category
    ){
        BeanUtils.copyProperties(category, categoryFromDB, "id");
        return categoryRepository.save(categoryFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Category category){
        categoryRepository.delete(category);
    }
}
