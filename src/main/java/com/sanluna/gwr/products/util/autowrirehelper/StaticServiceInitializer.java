package com.sanluna.gwr.products.util.autowrirehelper;

import com.sanluna.gwr.products.service.ProductCampaignService;
import com.sanluna.gwr.products.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticServiceInitializer {

    @Autowired
    private ProductGroupService productGroupService;
    @Autowired
    private ProductCampaignService productCampaignService;

    @PostConstruct
    public void init() {
        ServiceFactory.productGroupService = this.productGroupService;
        ServiceFactory.productCampaignService = this.productCampaignService;
    }

}
