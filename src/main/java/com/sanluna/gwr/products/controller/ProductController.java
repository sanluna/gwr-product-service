package com.sanluna.gwr.products.controller;

import com.sanluna.commons.controller.BaseController;
import com.sanluna.gwr.products.model.Product;
import com.sanluna.gwr.products.model.entity.ProductEntity;
import com.sanluna.gwr.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "products", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductController implements BaseController<Product> {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> fetchAll(){
        return service.fetchAll().stream().map(ProductEntity::convertToDTO).collect(Collectors.toList());
    }

    @Override
    @PostMapping
    public Product save(@RequestBody Product dto) {
        return service.save(dto.convertToEntity()).convertToDTO();
    }
    @Override
    @GetMapping("{ID}")
    public Product getById(@PathVariable("ID") String ID) {
        return service.getById(ID).convertToDTO();
    }

    @Override
    @PutMapping
    public Product update(@RequestBody Product dto) {
        return service.update(dto.convertToEntity()).convertToDTO();
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody Product dto) {
        service.delete(dto.convertToEntity());
    }

    @Override
    @DeleteMapping("{ID}")
    public void deleteById(@PathVariable("ID") String ID) {
        service.deleteById(ID);
    }
}
