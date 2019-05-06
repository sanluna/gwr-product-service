package com.sanluna.gwr.products.util;

import com.sanluna.commons.exceptions.IncorrectValuesEntered;
import com.sanluna.gwr.products.model.entity.ProductCampaignEntity;

public class BussinessRules {

    public static boolean validateCampaign(ProductCampaignEntity entity) {
        // confirm atleast 1 campaign type is filled in
        if(entity.getPercentageOff() == 0 && entity.getBuyX() == 0 && entity.getForY() == 0 && entity.getDeductSum() == null){
            throw new IncorrectValuesEntered("invalid campaign");
        }
        // confirm no more than 1 campaign type is filled in
        if(entity.getDeductSum() != null){
            return entity.getPercentageOff() == 0 && entity.getBuyX() == 0 && entity.getForY() == 0;
        } else if(entity.getPercentageOff() != 0){
            return entity.getBuyX() == 0 && entity.getForY() == 0;
        } else return entity.getBuyX() != 0 && entity.getForY() != 0;
    }
}
