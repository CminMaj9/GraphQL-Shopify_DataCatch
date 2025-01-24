package com.gfj.graphqlshopify.scheduler;

import com.gfj.graphqlshopify.controller.queryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author gefangjie
 * @data 2025/1/14 10:38
 */

@EnableScheduling
@Service
public class DataSyncScheduler {
    @Autowired
    private queryController queryController;

    @Scheduled(cron = "0 0 7 * * ?")
    public void syncOrders() {
        try {
            // TODO: 实现每天定时同步订单、货物、客户数据等
            queryController.queryOrder("orderQuery.graphql");
            queryController.queryProduct("productQuery.graphql");
            queryController.queryCustomer("customerQuery.graphql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
