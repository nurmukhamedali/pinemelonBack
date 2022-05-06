package kz.pinemelon.services;

import kz.pinemelon.form.ProductForm;
import kz.pinemelon.entities.Category;
import kz.pinemelon.entities.Component;
import kz.pinemelon.entities.Product;
import kz.pinemelon.repositories.CategoryRepository;
import kz.pinemelon.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Product create(ProductForm productForm){
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setImage(productForm.getImage());
        product.setEnabled(productForm.isEnabled());
        product.setBrand(productForm.getBrand());
        product.setPrice(productForm.getPrice());
        product.setAmount(productForm.getAmount());
        if (productForm.getCategory_id() != null) {
            if (categoryRepository.existsById(productForm.getCategory_id())) {
                Category category = categoryRepository.getById(productForm.getCategory_id());
                product.setCategory(category);
            }
        }
        product.setCreationDate(LocalDateTime.now());
        product.setUpdateDate(LocalDateTime.now());
        return productRepository.save(product);
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

    public List<Product> listAll(Category category){
        if (category == null)
            return productRepository.findAll();
        else if (!categoryRepository.existsById(category.getId())){
            return productRepository.findAll();
        }
        return this.getProducts(category);
    }

    public Product update(Product product, ProductForm temp){
        // refresh values of product by values of temp
        if (temp.getName() != null){
            product.setName(temp.getName());
        }
        if (temp.getDescription() != null){
            product.setDescription(temp.getDescription());
        }
        if (temp.getImage() != null){
            product.setImage(temp.getImage());
        }
        if (temp.isEnabled()){
            product.setEnabled(temp.isEnabled());
        }
        if (temp.getBrand() != null){
            product.setBrand(temp.getBrand());
        }
        if (temp.getAmount() != -1){
            product.setAmount(temp.getAmount());
        }
        if (temp.getPrice() != 0){
            product.setPrice(temp.getPrice());
        }
        if (temp.getCategory_id() != null) {
            if (categoryRepository.existsById(temp.getCategory_id())) {
                Category category = categoryRepository.getById(temp.getCategory_id());
                product.setCategory(category);
            }
        }
        product.setUpdateDate(LocalDateTime.now());
        return productRepository.save(product);
    }
    public void delete(Product product){
        productRepository.delete(product);
    }
}
