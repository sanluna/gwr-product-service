package com.sanluna.gwr.products.model.entity;

import com.sanluna.commons.model.entity.BaseEntity;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.ProductGroup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_groups")
public class ProductGroupEntity extends BaseEntity<ProductGroupEntity> {

    @Column(name = "group_name")
    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public ProductGroupEntity setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    @Override
    public ProductGroup convertToDTO() {
        return Converter.toDTO(this, new ProductGroup()
                .setGroupName(getGroupName()));
    }

    @Override
    public ProductGroupEntity updateEntity(ProductGroupEntity newEntity) {
        return null;
    }
}
