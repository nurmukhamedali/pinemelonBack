package kz.pinemelon.controller;

import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Product;
import kz.pinemelon.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping("{id}")
    public Product get(@PathVariable("id") Product product){
        return product;
    }

    @CrossOrigin(origins="*")
    @PostMapping
    public Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @CrossOrigin(origins="http://localhost:8080")
    @PutMapping("{id}")
    public Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody Product product
    ){
        BeanUtils.copyProperties(product, productFromDB, "id");
        return productRepository.save(productFromDB);
    }

    @CrossOrigin(origins="http://localhost:8080")
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Product product){
        productRepository.delete(product);
    }
}
