package com.sanluna.gwr.products.controller;

import com.sanluna.commons.controller.BaseController;
import com.sanluna.gwr.products.model.ProductGroup;
import com.sanluna.gwr.products.model.entity.ProductGroupEntity;
import com.sanluna.gwr.products.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "productgroups", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductGroupController implements BaseController<ProductGroup> {

    @Autowired
    private ProductGroupService service;

    @GetMapping("search/{ProductGroup}")
    public ProductGroup findBrandByName(@PathVariable("ProductGroup") String productGroup){
       return service.findByGroupName(productGroup).convertToDTO();
    }

    @GetMapping
    public List<ProductGroup> fetchAll(){
        return service.fetchAll().stream().map(ProductGroupEntity::convertToDTO).collect(Collectors.toList());
    }

    @Override
    @PostMapping
    public ProductGroup save(@RequestBody ProductGroup dto) {
        return service.save(dto.convertToEntity()).convertToDTO();
    }
    @Override
    @GetMapping("/{ID}")
    public ProductGroup getById(@PathVariable("ID") String ID) {
        return service.getById(ID).convertToDTO();
    }

    @Override
    @PutMapping
    public ProductGroup update(@RequestBody ProductGroup dto) {
        return service.update(dto.convertToEntity()).convertToDTO();
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody ProductGroup dto) {
        service.delete(dto.convertToEntity());
    }

    @Override
    @DeleteMapping("/{ID}")
    public void deleteById(@PathVariable("ID") String ID) {
        service.deleteById(ID);
    }
}
