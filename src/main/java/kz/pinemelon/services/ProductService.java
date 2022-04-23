package kz.pinemelon.services;

import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Component;
import kz.pinemelon.entities.Product;
import kz.pinemelon.repositories.CategoryRepository;
import kz.pinemelon.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Product create(Product product){
        product.setCreationDate(LocalDateTime.now());
        product.setUpdateDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public List<Product> listAll(){
        return productRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    private List<Product> getProducts(Category category){
        List<Product> products = new ArrayList<>();
        for (Component component: category.getComponents()) {
            if (component instanceof Product){
                products.add((Product) component);
            } else if (component instanceof Category){
                products.addAll(this.getProducts((Category) component));
            }
        }
        return products;
    }

    public List<Product> listByCategory(Category category){
        if (categoryRepository.existsById(category.getId())){
            return this.getProducts(category);
        }
        return null;
    }

    public Product update(Product product, Product temp){
        // refresh values of product by values of temp
        BeanUtils.copyProperties(temp, product, "id");
        product.setUpdateDate(LocalDateTime.now());
        return productRepository.save(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }
}
