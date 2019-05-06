package com.sanluna.gwr.products.service;

import com.sanluna.commons.service.GenericService;
import com.sanluna.gwr.products.model.entity.ProductEntity;
import com.sanluna.gwr.products.model.entity.ProductGroupEntity;
import com.sanluna.gwr.products.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductGroupService extends GenericService<ProductGroupEntity> {

    @Autowired
    private ProductGroupRepository repository;

    public ProductGroupEntity findByGroupName(String groupName){
        ProductGroupEntity productGroupEntity = repository.findByGroupName(groupName);
        if(productGroupEntity == null){
            throw new EntityNotFoundException("Product group not found!");
        }
        return productGroupEntity;
    }

}
