package com.skptech.drools.demo.service;

import com.skptech.drools.demo.model.OrderDiscount;
import com.skptech.drools.demo.model.OrderRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderDiscountService {

    private final KieContainer kieContainer;

    @Autowired
    public OrderDiscountService(@Qualifier("kieContainerDiscount") KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public OrderDiscount getOrderDiscount(OrderRequest orderRequest) {
        OrderDiscount orderDiscount = new OrderDiscount();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("orderDiscount", orderDiscount);
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return orderDiscount;
    }

}
