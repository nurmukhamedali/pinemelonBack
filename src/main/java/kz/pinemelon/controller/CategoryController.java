package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.View;
import kz.pinemelon.form.CategoryForm;
import kz.pinemelon.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins="http://localhost:8080")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    @JsonView(View.ComponentView.Public.class)
    public List<Category> getCategories(@RequestParam(required = false, value = "categoryId", defaultValue = "0") Category category) {
        return categoryService.list(category);
    }

    @GetMapping("/categories/{id}")
    @JsonView(View.ComponentView.Internal.class)
    public Category get(
            @PathVariable("id") Category category){
        return category;
    }

    @PostMapping("/categories")
    @JsonView(View.ComponentView.Public.class)
    public Category create(
            @RequestBody CategoryForm category
    ) {
        return categoryService.create(category);
    }

    @PutMapping("/categories/{id}")
    @JsonView(View.ComponentView.Public.class)
    public Category update(
            @PathVariable("id") Category categoryFromDB,
            @RequestBody Category category
    ){
        return categoryService.update(categoryFromDB, category);
    }

    @DeleteMapping("/categories/{id}")
    @JsonView(View.ComponentView.Public.class)
    public void delete(
            @PathVariable("id") Category category){
        categoryService.delete(category);
    }
}
