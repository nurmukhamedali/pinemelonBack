package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
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
@RequestMapping("category/{cat_id}/product")
@CrossOrigin(origins="http://localhost:8080")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @JsonView(Views.shortData.class)
    public Set<Product> getAll(@PathVariable("cat_id") Long category_id) {
        return productService.list(category_id);
    }

    @GetMapping("{id}")
    @JsonView(Views.fullData.class)
    public Product get(@PathVariable("id") Product product){
        return product;
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("{id}")
    public Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody Product product
    ){
        return productService.update(productFromDB, product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Product product){
        productService.delete(product);
    }
}
