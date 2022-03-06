package kz.pinemelon.controller;

import kz.pinemelon.entities.Category;
import kz.pinemelon.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Value("${upload.path}")
    private String uploadPath;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping("{id}")
    public Category get(@PathVariable("id") Category category){
        return category;
    }

    @CrossOrigin(origins="http://localhost:8080")
    @PostMapping
    public Category create(
            @RequestBody Category category
    ) {
        return categoryRepository.save(category);
    }

    @CrossOrigin(origins="http://localhost:8080")
    @PutMapping("{id}")
    public Category update(
            @PathVariable("id") Category categoryFromDB,
            @RequestBody Category category
    ){
        BeanUtils.copyProperties(category, categoryFromDB, "id");
        return categoryRepository.save(categoryFromDB);
    }

    @CrossOrigin(origins="http://localhost:8080")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Category category){
        categoryRepository.delete(category);
    }
}
