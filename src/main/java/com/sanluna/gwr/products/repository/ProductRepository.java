package com.sanluna.gwr.products.repository;

import com.sanluna.commons.repository.AOWR_Repository;
import com.sanluna.gwr.products.model.entity.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends AOWR_Repository<ProductEntity> {
}
