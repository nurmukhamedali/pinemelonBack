package kz.pinemelon.controller;

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

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("{id}")
    public Product get(@PathVariable("id") Product product){
        return product;
    }

    @PostMapping
    public Product create(Product product){
        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody Product product
    ){
        BeanUtils.copyProperties(product, productFromDB, "id");
        return productRepository.save(productFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Product product){
        productRepository.delete(product);
    }
}
