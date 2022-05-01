package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Product;
import kz.pinemelon.entities.View;
import kz.pinemelon.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:8080")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("category/{categoryId}/products")
    @JsonView(View.ComponentView.Public.class)
    public List<Product> getAll(@PathVariable("categoryId") Category category) {
        return productService.listByCategory(category);
    }

    @GetMapping("product")
    @JsonView(View.ComponentView.Public.class)
    public List<Product> getAll() {
        return productService.listAll();
    }

    @GetMapping("product/{id}")
    @JsonView(View.ComponentView.Internal.class)
    public Product get(@PathVariable("id") Product product){
        return product;
    }

    @PostMapping("product")
    @JsonView(View.ComponentView.Internal.class)
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("product/{id}")
    @JsonView(View.ComponentView.Internal.class)
    public Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody Product product
    ){
        return productService.update(productFromDB, product);
    }

    @DeleteMapping("product/{id}")
    @JsonView(View.ComponentView.Public.class)
    public void delete(@PathVariable("id") Product product){
        productService.delete(product);
    }
}
