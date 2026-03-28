package com.example.TNTRANSPORT.controller;


import com.example.TNTRANSPORT.model.Product;
import com.example.TNTRANSPORT.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService service;


    @PostMapping("/add")
    public Product addproduct(@RequestParam String name, @RequestParam double ratings, @RequestParam double price, @RequestParam int seats, @RequestParam String music, @RequestParam String AC, @RequestParam MultipartFile image){
        return service.addproduct(name, ratings, price, seats, music, AC, image);

    }

    @GetMapping("/get")
    public List<Product> getall(){
        return service.getall();
    }

    @GetMapping("/{id}")
    public  Product getsingle(@PathVariable Long id){
        return service.getsingle(id);
    }

    @PutMapping("/{id}")
    public  Product update(@PathVariable Long id, @RequestParam String name, @RequestParam double ratings, @RequestParam double price, @RequestParam int seats, @RequestParam String music, @RequestParam String AC, @RequestParam MultipartFile image){
        return service.updateproduct(id, name, ratings, price,seats, music, AC, image);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return  service.delete(id);
    }
}
