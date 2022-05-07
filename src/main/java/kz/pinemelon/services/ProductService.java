package kz.pinemelon.services;

import kz.pinemelon.domain.Category;
import kz.pinemelon.domain.Product;
import kz.pinemelon.form.ProductForm;
import kz.pinemelon.repositories.CategoryRepository;
import kz.pinemelon.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Product> findAll(Category category){
        if (category != null && categoryService.exist(category.getId()))
            return category.getProducts();
        return productRepository.findAll();
    }

    public Product create(ProductForm product){
        Product p = new Product();
        p.setName(product.getName());
        p.setBrand(product.getBrand());
        p.setImage(product.getImage());
        p.setPrice(product.getPrice());
        if (product.getCategory() != null)
            p.setCategory(categoryService.get(product.getCategory()));
        return productRepository.save(p);
    }

    public Product update(Product oldProduct, ProductForm product){
        oldProduct.setName(product.getName());
        oldProduct.setBrand(product.getBrand());
        oldProduct.setImage(product.getImage());
        oldProduct.setPrice(product.getPrice());
        if (product.getCategory() != null)
            oldProduct.setCategory(categoryService.get(product.getCategory()));
        return productRepository.save(oldProduct);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

    public ProductForm getDetails(Product product){
        ProductForm p = new ProductForm();
        p.setId(product.getId());
        p.setName(product.getName());
        p.setBrand(product.getBrand());
        p.setImage(product.getImage());
        p.setPrice(product.getPrice());
        p.setCategory(product.getCategory().getId());
        return p;
    }

    public ProductForm createDetails(ProductForm product){
        return getDetails(create(product));
    }

    public ProductForm updateDetails(Product oldProduct, ProductForm product){
        return getDetails(update(oldProduct, product));
    }

    public List<ProductForm> findAllDetails(Category category){
        List<ProductForm> forms = new ArrayList<>();
        for (Product product: findAll(category)) {
            forms.add(getDetails(product));
        }
        return forms;
    }

    public Product get(Long id){
        return productRepository.getById(id);
    }
}
