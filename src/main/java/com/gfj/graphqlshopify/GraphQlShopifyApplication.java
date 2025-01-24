package com.gfj.graphqlshopify;

import com.gfj.graphqlshopify.service.queryService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlShopifyApplication {

    @Autowired
    private queryService queryService;

    public static void main(String[] args) {
        SpringApplication.run(GraphQlShopifyApplication.class, args);

    }

    @PostConstruct
    public void fetchOrdersOnStartup() {
        try {
            // TODO: 放测试方法的地方
        } catch (Exception e) {
            System.err.println("Error during fetch and save orders: " + e.getMessage());
        }
    }
}
