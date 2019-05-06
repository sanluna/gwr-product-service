package com.sanluna.gwr.products.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sanluna.commons.model.BaseDTO;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.sanluna.gwr.products.util.autowrirehelper.ServiceFactory.productGroupService;

@JsonInclude(Include.NON_NULL)
public class Product extends BaseDTO<Product> {

    private String name;
    private String articleNumber;
    private String producerArticleNumber;
    private String description;
    private String productInfo;
    private int storageQuantity;
    private BigDecimal inPrice;
    private BigDecimal outPrice;
    private BigDecimal outPriceCampaign;
    private String brand;
    private List<String> productGroups;
    private ProductCampaign campaign;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public Product setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
        return this;
    }

    public String getProducerArticleNumber() {
        return producerArticleNumber;
    }

    public Product setProducerArticleNumber(String producerArticleNumber) {
        this.producerArticleNumber = producerArticleNumber;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public Product setProductInfo(String productInfo) {
        this.productInfo = productInfo;
        return this;
    }

    public int getStorageQuantity() {
        return storageQuantity;
    }

    public Product setStorageQuantity(int storageQuantity) {
        this.storageQuantity = storageQuantity;
        return this;
    }

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public Product setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
        return this;
    }

    public BigDecimal getOutPrice() {
        return outPrice;
    }

    public Product setOutPrice(BigDecimal outPrice) {
        this.outPrice = outPrice;
        if(getCampaign() != null){
            BigDecimal percentage = BigDecimal.valueOf(getCampaign().getPercentageOff()*0.01);
            this.outPriceCampaign = outPrice.subtract(getCampaign().getSumOff() == null ? BigDecimal.ZERO : getCampaign().getSumOff());
            this.outPriceCampaign = this.outPriceCampaign.subtract(outPrice.multiply(percentage));
        }
        return this;
    }

    public BigDecimal getOutPriceCampaign() {
        return outPriceCampaign;
    }

    public String getBrand() {
        return brand;
    }

    public Product setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public List<String> getProductGroups() {
        return productGroups;
    }

    public Product setProductGroups(List<String> productGroups) {
        this.productGroups = productGroups;
        return this;
    }

    public ProductCampaign getCampaign() {
        return campaign;
    }

    public Product setCampaign(ProductCampaign campaign) {
        this.campaign = campaign;
        return this;
    }

    public ProductEntity convertToEntity() {
        return Converter.toEntity(this, new ProductEntity())
                .setName(getName())
                .setArticleNumber(getArticleNumber())
                .setDescription(getDescription())
                .setInPrice(getInPrice())
                .setOutPrice(getOutPrice())
                .setProducerArticleNumber(getProducerArticleNumber())
                .setProductInfo(getProductInfo())
                .setStorageQuantity(getStorageQuantity())
                .setBrand(getBrand())
                .setProductGroups(getProductGroups().stream().map(x -> productGroupService.findByGroupName(x)).collect(Collectors.toList()))
                .setCampaign(getCampaign() == null ? null : UUID.fromString(getCampaign().getId()));
    }
}
