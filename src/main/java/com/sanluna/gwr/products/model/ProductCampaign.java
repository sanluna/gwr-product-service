package com.sanluna.gwr.products.model;

import com.sanluna.commons.model.BaseDTO;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.entity.ProductCampaignEntity;

import java.math.BigDecimal;

public class ProductCampaign extends BaseDTO<ProductCampaign> {

    private String campaignName;
    private String expireDate;
    private double percentageOff;
    private BigDecimal sumOff;
    private int buyX;
    private int forY;

    public String getCampaignName() {
        return campaignName;
    }

    public ProductCampaign setCampaignName(String campaignName) {
        this.campaignName = campaignName;
        return this;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public ProductCampaign setExpireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public double getPercentageOff() {
        return percentageOff;
    }

    public ProductCampaign setPercentageOff(double percentageOff) {
        this.percentageOff = percentageOff;
        return this;
    }


    public int getBuyX() {
        return buyX;
    }

    public int getForY() {
        return forY;
    }

    public ProductCampaign setBuyX(int buyX) {
        this.buyX = buyX;
        return this;
    }

    public ProductCampaign setForY(int forY) {
        this.forY = forY;
        return this;
    }

    public ProductCampaign setBuyXForY(int buyX, int forY) {
        if (forY < buyX && buyX > 1 && forY > 0) {
            this.buyX = buyX;
            this.forY = forY;
        }
        return this;
    }

    public BigDecimal getSumOff() {
        return sumOff;
    }

    public ProductCampaign setSumOff(BigDecimal sumOff) {
        this.sumOff = sumOff;
        return this;
    }

    @Override
    public ProductCampaignEntity convertToEntity() {
        return Converter.toEntity(this, new ProductCampaignEntity())
                .setCampaignName(getCampaignName())
                .setBuyXForY(getBuyX(), getForY())
                .setDeductSum(getSumOff())
                .setExpireDate(Converter.formatTime(getExpireDate()))
                .setPercentageOff(getPercentageOff());
    }


}
