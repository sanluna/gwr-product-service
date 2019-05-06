package com.sanluna.gwr.products.service;

import com.sanluna.commons.exceptions.IncorrectValuesEntered;
import com.sanluna.commons.service.GenericService;
import com.sanluna.gwr.products.model.entity.ProductCampaignEntity;
import com.sanluna.gwr.products.repository.ProductCampaignRepository;
import com.sanluna.gwr.products.util.BussinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCampaignService extends GenericService<ProductCampaignEntity> {

    @Autowired
    private ProductCampaignRepository repository;

    @Override
    public ProductCampaignEntity save(ProductCampaignEntity entity) {
        if (!BussinessRules.validateCampaign(entity)) {
            throw new IncorrectValuesEntered("only 1 campaign type allowed per campaign");
        }
        return super.save(entity);
    }



}
