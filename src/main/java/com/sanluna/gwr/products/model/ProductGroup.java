package com.sanluna.gwr.products.model;

import com.sanluna.commons.model.BaseDTO;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.entity.ProductGroupEntity;

public class ProductGroup extends BaseDTO<ProductGroup> {

    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public ProductGroup setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    @Override
    public ProductGroupEntity convertToEntity() {
        return Converter.toEntity(this, new ProductGroupEntity()
                .setGroupName(getGroupName()));
    }
}
