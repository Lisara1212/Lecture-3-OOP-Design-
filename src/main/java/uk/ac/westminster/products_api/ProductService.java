package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService{

    private List<Product> products = new ArrayList<>();//its products array list

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) { //not null passing through this
        return products.stream()
        //convert the array line to pipe line
                .filter(p ->p.getId().equals(id))
                .findFirst()
                .orElse(null);








    }
    public Product addProduct(Product product) {
        products.set(0, product);

        products.add(product);
        return product;


    }
    public Product updateProduct(Product product) {
        products.removeIf(p -> p.getId().equals(product.getId()));
        return product;






    }


}