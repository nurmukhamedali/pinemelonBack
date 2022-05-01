package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Product;
import kz.pinemelon.entities.View;
import kz.pinemelon.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin(origins="http://localhost:8080")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}/categories")
    @JsonView(View.ComponentView.Public.class)
    public List<Category> getAll(@PathVariable("id") Category category) {
        return categoryService.listByCategory(category);
    }

    @GetMapping
    @JsonView(View.ComponentView.Public.class)
    List<Category> getAll() {
        return categoryService.list();
    }

    @GetMapping("{id}")
    @JsonView(View.ComponentView.Internal.class)
    public Category get(
            @PathVariable("id") Category category){
        return category;
    }

    @PostMapping
    @JsonView(View.ComponentView.Public.class)
    public Category create(
            @RequestBody Category category
    ) {
        return categoryService.create(category);
    }

    @PutMapping("{id}")
    @JsonView(View.ComponentView.Public.class)
    public Category update(
            @PathVariable("id") Category categoryFromDB,
            @RequestBody Category category
    ){
        return categoryService.update(categoryFromDB, category);
    }

    @DeleteMapping("{id}")
    @JsonView(View.ComponentView.Public.class)
    public void delete(
            @PathVariable("id") Category category){
        categoryService.delete(category);
    }
}
