package kz.pinemelon.services;

import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Product;
import kz.pinemelon.repositories.CategoryRepository;
import kz.pinemelon.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

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

    private List<Product> listAll(){
        return productRepository.findAll();
    }

    private List<Product> listByCategory(Category category){
        return category.getProducts();
    }

    public List<Product> list(Long category_id){
        if (categoryRepository.existsById(category_id)){
            Category category = categoryRepository.getById(category_id);
            return listByCategory(category);
        } else {
            return listAll();
        }

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
