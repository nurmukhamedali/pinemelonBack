package kz.pinemelon.controller;

import kz.pinemelon.domain.Product;
import kz.pinemelon.domain.Category;
import kz.pinemelon.form.ProductForm;
import kz.pinemelon.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins="*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductForm> getProducts(@RequestParam(required = false, value = "categoryId", defaultValue = "0") Category category) {
        return productService.findAllDetails(category);
    }

    @GetMapping("/products/{id}")
    public ProductForm get(@PathVariable("id") Product product){
        return productService.getDetails(product);
    }

    @PostMapping("/products")
    public ProductForm create(@RequestBody ProductForm product){
        return productService.createDetails(product);
    }

    @PutMapping("/products/{id}")
    public ProductForm update(
            @PathVariable("id") Product oldProduct,
            @RequestBody ProductForm product
    ){
        return productService.updateDetails(oldProduct, product);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") Product product){
        productService.delete(product);
    }
}
