package kz.pinemelon.controller;

import com.fasterxml.jackson.annotation.JsonView;
import kz.pinemelon.form.ProductForm;
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

    @GetMapping("/products")
    @JsonView(View.ComponentView.Public.class)
    public List<Product> getProducts(@RequestParam(required = false, value = "categoryId", defaultValue = "0") Category category) {
        return productService.listAll(category);
    }

    @GetMapping("/products/{id}")
    @JsonView(View.ComponentView.Internal.class)
    public Product get(@PathVariable("id") Product product){
        return product;
    }

    @PostMapping("/products")
    @JsonView(View.ComponentView.Internal.class)
    public Product create(@RequestBody ProductForm product){
        return productService.create(product);
    }

    @PutMapping("/products/{id}")
    @JsonView(View.ComponentView.Internal.class)
    public Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody ProductForm product
    ){
        return productService.update(productFromDB, product);
    }

    @DeleteMapping("/products/{id}")
    @JsonView(View.ComponentView.Public.class)
    public void delete(@PathVariable("id") Product product){
        productService.delete(product);
    }
}
