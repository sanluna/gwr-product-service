package com.sanluna.gwr.products.model.entity;

import com.sanluna.commons.model.entity.BaseEntity;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.sanluna.gwr.products.util.autowrirehelper.ServiceFactory.productCampaignService;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity<ProductEntity> {

    @Column(name = "name")
    private String name;
    @Column(name = "article_number")
    private String articleNumber;
    @Column(name = "producer_article_number")
    private String producerArticleNumber;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "product_info")
    private String productInfo;
    @Column(name = "storage_quantity")
    private int storageQuantity;
    @Column(name = "in_price")
    private BigDecimal inPrice;
    @Column(name = "out_price")
    private BigDecimal outPrice;
    @Column(name = "brand")
    private String brand;
    @ManyToMany
    @JoinTable(
            name = "product_groups_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_group_id"))
    private List<ProductGroupEntity> productGroups;
    @Column(name = "product_campaign", columnDefinition = "binary(16)")
    private UUID campaign;

    public String getName() {
        return name;
    }

    public ProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public ProductEntity setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
        return this;
    }

    public String getProducerArticleNumber() {
        return producerArticleNumber;
    }

    public ProductEntity setProducerArticleNumber(String producerArticleNumber) {
        this.producerArticleNumber = producerArticleNumber;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public ProductEntity setProductInfo(String productInfo) {
        this.productInfo = productInfo;
        return this;
    }

    public int getStorageQuantity() {
        return storageQuantity;
    }

    public ProductEntity setStorageQuantity(int storageQuantity) {
        this.storageQuantity = storageQuantity;
        return this;
    }

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public ProductEntity setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
        return this;
    }

    public BigDecimal getOutPrice() {
        return outPrice;
    }

    public ProductEntity setOutPrice(BigDecimal outPrice) {
        this.outPrice = outPrice;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ProductEntity setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public List<ProductGroupEntity> getProductGroups() {
        return productGroups;
    }

    public ProductEntity setProductGroups(List<ProductGroupEntity> productGroups) {
        this.productGroups = productGroups;
        return this;
    }

    public UUID getCampaign() {
        return campaign;
    }

    public ProductEntity setCampaign(UUID campaign) {
        this.campaign = campaign;
        return this;
    }


    public Product convertToDTO() {
        return Converter.toDTO(this, new Product())
                .setName(getName())
                .setArticleNumber(getArticleNumber())
                .setDescription(getDescription())
                .setInPrice(getInPrice())
                .setProducerArticleNumber(getProducerArticleNumber())
                .setProductInfo(getProductInfo())
                .setStorageQuantity(getStorageQuantity())
                .setBrand(getBrand())
                .setProductGroups(getProductGroups().stream().map(ProductGroupEntity::getGroupName).collect(Collectors.toList()))
                .setCampaign(getCampaign() == null ? null : productCampaignService.getById(getCampaign().toString()).convertToDTO())
                .setOutPrice(getOutPrice())
                ;
    }


    @Override
    public ProductEntity updateEntity(ProductEntity newEntity) {
        if(newEntity.getBrand() != null) setBrand(newEntity.getBrand());
        if(newEntity.getCampaign() != null) setCampaign(newEntity.getCampaign());
        if(newEntity.getArticleNumber() != null) setArticleNumber(newEntity.getArticleNumber());
        if(newEntity.getName() != null) setName(newEntity.getName());
        if(newEntity.getDescription() != null) setDescription(newEntity.getDescription());
        if(newEntity.getInPrice() != null) setInPrice(newEntity.getInPrice());
        if(newEntity.getOutPrice() != null) setOutPrice(newEntity.getOutPrice());
        if(newEntity.getProducerArticleNumber() != null) setProducerArticleNumber(newEntity.getProducerArticleNumber());
        if(newEntity.getProductGroups() != null) setProductGroups(newEntity.getProductGroups());
        if(newEntity.getProductInfo() != null) setProductInfo(newEntity.getProductInfo());
        if(newEntity.getStorageQuantity() != 0) setStorageQuantity(newEntity.getStorageQuantity());
        return this;
    }
}
