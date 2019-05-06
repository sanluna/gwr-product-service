package com.sanluna.gwr.products.model.entity;

import com.sanluna.commons.model.entity.BaseEntity;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.ProductReview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product_reviews")
public class ProductReviewEntity extends BaseEntity<ProductReviewEntity> {

    @Column(name = "product_id", columnDefinition = "binary(16)")
    private UUID product_id;
    @Column(name = "review", length = 2000)
    private String review;
    @Column(name = "rating")
    private int rating;

    public UUID getProduct_id() {
        return product_id;
    }

    public ProductReviewEntity setProduct_id(UUID product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getReview() {
        return review;
    }

    public ProductReviewEntity setReview (String review) {
        this.review = review;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public ProductReviewEntity setRating(int rating) {
        if (rating < 0) {
            rating = 0;
        }
        if (rating > 10) {
            rating = 10;
        }
        this.rating = rating;
        return this;
    }

    @Override
    public ProductReview convertToDTO() {
        return Converter.toDTO(this, new ProductReview())
                .setReview(getReview())
                .setRating(getRating());
    }

    @Override
    public ProductReviewEntity updateEntity(ProductReviewEntity newEntity) {
        return null;
    }
}
