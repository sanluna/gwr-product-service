package com.sanluna.gwr.products.model;

import com.sanluna.commons.model.BaseDTO;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.entity.ProductReviewEntity;

public class ProductReview extends BaseDTO<ProductReview> {

    private String review;
    private int rating;

    public String getReview() {
        return review;
    }

    public ProductReview setReview(String review) {
        this.review = review;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public ProductReview setRating(int rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public ProductReviewEntity convertToEntity() {
        return Converter.toEntity(this, new ProductReviewEntity().setReview(getReview()).setRating(getRating()));
    }
}
