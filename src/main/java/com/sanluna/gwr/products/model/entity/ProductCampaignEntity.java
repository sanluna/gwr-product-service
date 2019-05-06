package com.sanluna.gwr.products.model.entity;

import com.sanluna.commons.exceptions.IncorrectValuesEntered;
import com.sanluna.commons.model.entity.BaseEntity;
import com.sanluna.commons.util.Converter;
import com.sanluna.gwr.products.model.ProductCampaign;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_campaigns")
public class ProductCampaignEntity extends BaseEntity<ProductCampaignEntity> {

    @Column(name = "campaign_name", unique = true)
    private String campaignName;
    @Column(name = "expire_date")
    private LocalDateTime expireDate;
    @Column(name = "percentage_off")
    private double percentageOff;
    @Column(name = "sum_off")
    private BigDecimal sumOff;
    @Column(name = "buy_x")
    private int buyX;
    @Column(name = "for_y")
    private int forY;

    public String getCampaignName() {
        return campaignName;
    }

    public ProductCampaignEntity setCampaignName(String campaignName) {
        this.campaignName = campaignName;
        return this;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public ProductCampaignEntity setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public double getPercentageOff() {
        return percentageOff;
    }

    public ProductCampaignEntity setPercentageOff(double percentageOff) {
        if (percentageOff >= 0 && percentageOff <= 100) {
            this.percentageOff = percentageOff;
        } else {
            throw new IncorrectValuesEntered("Enter a value between 0 and 100");
        }
        return this;
    }

    public BigDecimal getDeductSum() {
        return sumOff;
    }

    public ProductCampaignEntity setDeductSum(BigDecimal sumOff) {
        this.sumOff = sumOff;
        return this;
    }

    public int getBuyX() {
        return buyX;
    }

    public int getForY() {
        return forY;
    }

    public ProductCampaignEntity setBuyXForY(int buyX, int forY) {
        if (buyX != 0 && forY != 0) {
            if (forY < buyX && buyX > 1 && forY > 0) {
                this.buyX = buyX;
                this.forY = forY;
            } else {
                throw new IncorrectValuesEntered("You entered incorrect values.");
            }
        }
        return this;
    }

    @Override
    public ProductCampaign convertToDTO() {
        return Converter.toDTO(this, new ProductCampaign())
                .setCampaignName(getCampaignName())
                .setBuyXForY(getBuyX(), getForY())
                .setSumOff(getDeductSum())
                .setExpireDate(Converter.formatTime(getExpireDate()))
                .setPercentageOff(getPercentageOff());
    }


    @Override
    public ProductCampaignEntity updateEntity(ProductCampaignEntity newEntity) {
        return null;
    }
}
