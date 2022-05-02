package com.skptech.drools.demo.service;

import com.skptech.drools.demo.model.Fare;
import com.skptech.drools.demo.model.TaxiRide;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TaxiFareCalculatorService {

    private final KieContainer kieContainer;

    @Autowired
    public TaxiFareCalculatorService(@Qualifier("kieContainerTaxiFare") KieContainer kieContainer){
        this.kieContainer = kieContainer;
    }

    public Long calculateFare(TaxiRide taxiRide){
        Fare rideFare = new Fare();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();
        return rideFare.getTotalFare();
    }

}
