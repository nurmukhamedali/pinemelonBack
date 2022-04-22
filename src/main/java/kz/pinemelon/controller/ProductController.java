package kz.pinemelon.controller;

import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Product;
import kz.pinemelon.entities.Views;
import kz.pinemelon.repositories.ProductRepository;
import kz.pinemelon.services.CategoryService;
import kz.pinemelon.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:8080")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("category/{categoryId}/products")
    public List<Product> getAll(@PathVariable("categoryId") Category category) {
        return productService.listByCategory(category);
    }

    @GetMapping("product")
    public List<Product> getAll() {
        return productService.listAll();
    }

    @GetMapping("product/{id}")
    public Product get(@PathVariable("id") Product product){
        return product;
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("product/{id}")
    public Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody Product product
    ){
        return productService.update(productFromDB, product);
    }

    @DeleteMapping("product/{id}")
    public void delete(@PathVariable("id") Product product){
        productService.delete(product);
    }
}
