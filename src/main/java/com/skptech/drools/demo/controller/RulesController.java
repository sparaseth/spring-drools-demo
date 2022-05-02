package com.skptech.drools.demo.controller;

import com.skptech.drools.demo.model.OrderDiscount;
import com.skptech.drools.demo.model.OrderRequest;
import com.skptech.drools.demo.model.TaxiRide;
import com.skptech.drools.demo.service.OrderDiscountService;
import com.skptech.drools.demo.service.TaxiFareCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RulesController {

    private final OrderDiscountService orderDiscountService;
    private final TaxiFareCalculatorService taxiFareCalculatorService;

    @Autowired
    public RulesController(OrderDiscountService orderDiscountService, TaxiFareCalculatorService taxiFareCalculatorService) {
        this.orderDiscountService = orderDiscountService;
        this.taxiFareCalculatorService = taxiFareCalculatorService;
    }

    @PostMapping("/get-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
        OrderDiscount orderDiscount = orderDiscountService.getOrderDiscount(orderRequest);
        return new ResponseEntity<>(orderDiscount, HttpStatus.OK);
    }

    @PostMapping("/get-taxi-fare")
    public ResponseEntity<Long> getTaxiFare(@RequestBody TaxiRide taxiRide) {
        Long calculatedFare = taxiFareCalculatorService.calculateFare(taxiRide);
        return new ResponseEntity<>(calculatedFare, HttpStatus.OK);
    }

}
