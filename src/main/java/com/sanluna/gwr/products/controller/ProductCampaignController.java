package com.sanluna.gwr.products.controller;

import com.sanluna.commons.controller.BaseController;
import com.sanluna.gwr.products.model.ProductCampaign;
import com.sanluna.gwr.products.model.entity.ProductCampaignEntity;
import com.sanluna.gwr.products.service.ProductCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "productcampaigns", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class ProductCampaignController implements BaseController<ProductCampaign> {

    @Autowired
    private ProductCampaignService service;

    @GetMapping
    public List<ProductCampaign> fetchAll() {
        return service.fetchAll().stream().map(ProductCampaignEntity::convertToDTO).collect(Collectors.toList());
    }

    @Override
    @PostMapping
    public ProductCampaign save(@RequestBody ProductCampaign dto) {
        return service.save(dto.convertToEntity()).convertToDTO();
    }

    @Override
    @GetMapping("{ID}")
    public ProductCampaign getById(@PathVariable("ID") String ID) {
        return service.getById(ID).convertToDTO();
    }

    @Override
    @PutMapping
    public ProductCampaign update(@RequestBody ProductCampaign dto) {
        return service.update(dto.convertToEntity()).convertToDTO();
    }

    @Override
    @DeleteMapping
    public void delete(@RequestBody ProductCampaign dto) {
        service.delete(dto.convertToEntity());
    }

    @Override
    @DeleteMapping("{ID}")
    public void deleteById(@PathVariable("ID") String ID) {
        service.deleteById(ID);
    }
}
