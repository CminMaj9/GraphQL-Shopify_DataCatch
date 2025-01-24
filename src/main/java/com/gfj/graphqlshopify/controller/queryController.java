package com.gfj.graphqlshopify.controller;

import com.gfj.graphqlshopify.model.CustomerData;
import com.gfj.graphqlshopify.model.OrderData;
import com.gfj.graphqlshopify.model.ProductData;
import com.gfj.graphqlshopify.service.DatabaseService;
import com.gfj.graphqlshopify.service.queryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @Author gefangjie
 * @data 2025/1/10 15:08
 */
@Controller
public class queryController {

    @Autowired
    private queryService queryService;
    @Autowired
    private DatabaseService databaseService;

    // 查询订单
    public void queryOrder(String fileName) throws IOException {
        String response = queryService.fetchAndSaveDataLastTwoDays(fileName);
        databaseService.saveData(OrderData.class, response);
    }

    // 查询货物
    public void queryProduct(String fileName) throws IOException {
        String response = queryService.fetchAndSaveDataLastTwoDays(fileName);
        databaseService.saveData(ProductData.class, response);
    }

    // 查询客户
    public void queryCustomer(String fileName) throws IOException {
        String response = queryService.fetchAndSaveDataLastTwoDays(fileName);
        databaseService.saveData(CustomerData.class, response);
    }
}
