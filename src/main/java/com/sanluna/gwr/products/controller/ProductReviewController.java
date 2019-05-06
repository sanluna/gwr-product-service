package com.sanluna.gwr.products.controller;

import com.sanluna.commons.controller.BaseController;
import com.sanluna.gwr.products.model.ProductGroup;
import com.sanluna.gwr.products.model.ProductReview;
import com.sanluna.gwr.products.model.entity.ProductGroupEntity;
import com.sanluna.gwr.products.model.entity.ProductReviewEntity;
import com.sanluna.gwr.products.service.ProductGroupService;
import com.sanluna.gwr.products.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "productreviews", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductReviewController implements BaseController<ProductReview> {

    @Autowired
    private ProductReviewService service;

    @GetMapping
    public List<ProductReview> fetchAll(){
        return service.fetchAll().stream().map(ProductReviewEntity::convertToDTO).collect(Collectors.toList());
    }

    @Override
    @PostMapping
    public ProductReview save(@RequestBody ProductReview dto) {
        return service.save(dto.convertToEntity()).convertToDTO();
    }

    @Override
    @GetMapping("{ID}")
    public ProductReview getById(@PathVariable("ID") String ID) {
        return service.getById(ID).convertToDTO();
    }

    @Override
    @PutMapping
    public ProductReview update(@RequestBody ProductReview dto) {
        return service.update(dto.convertToEntity()).convertToDTO();
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody ProductReview dto) {
        service.delete(dto.convertToEntity());
    }

    @Override
    @DeleteMapping("{ID}")
    public void deleteById(@PathVariable("ID") String ID) {
        service.deleteById(ID);
    }
}
