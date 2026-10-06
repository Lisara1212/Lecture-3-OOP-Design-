package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //private ProductService productService = new ProductService(); we dont do like this add autowired do it
    //developer dont add objects

     @Autowired
     private ProductService productService;
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
//        ArrayList<Product> list = new ArrayList<>();
//        list.add(new Product(1L, "Laptop", 999.99));
//        list.add(new Product(2L, "Keyboard", 8.78));
//        list.add(new Product(3L, "Mouse", 3.45));
//        return list;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
       // return new Product(id, "Laptop", 999.99);dont add manually
    }

    @PostMapping()
    public Product saveProduct(@RequestBody Product product) {
        //System.out.println(product);
       // return product;
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id) {
      // return "Delete endpoint executed: ID: " + id + " product has been deleted successfully";
        boolean isDeleted= getAllProducts().removeIf(product -> product.getId().equals(id));
        if(isDeleted)
            return "Product with id " + id + " has been deleted";
        else{
            return "Product with id " + id + " has been deleted";

        }


    }

}
