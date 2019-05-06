package com.sanluna.gwr.products.repository;

import com.sanluna.commons.repository.AOWR_Repository;
import com.sanluna.gwr.products.model.entity.ProductEntity;
import com.sanluna.gwr.products.model.entity.ProductReviewEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends AOWR_Repository<ProductReviewEntity> {
}
