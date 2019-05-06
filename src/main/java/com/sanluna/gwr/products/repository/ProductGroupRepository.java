package com.sanluna.gwr.products.repository;

import com.sanluna.commons.repository.AOWR_Repository;
import com.sanluna.gwr.products.model.entity.ProductGroupEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupRepository extends AOWR_Repository<ProductGroupEntity> {

    ProductGroupEntity findByGroupName(String productGroupName);

}
