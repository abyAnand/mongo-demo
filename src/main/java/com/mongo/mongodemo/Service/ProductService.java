package com.mongo.mongodemo.Service;

import com.mongo.mongodemo.Entity.Product;
import com.mongo.mongodemo.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String save(Product product){
        //TODO: use a DTO
        //TODO: validate the object
        return productRepository.save(product).getId();
    }

    public Product findbyId(String id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }
}
