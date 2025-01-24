package com.gfj.graphqlshopify.scheduler;

import com.gfj.graphqlshopify.controller.queryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author gefangjie
 * @data 2025/1/10 15:35
 */
@SpringBootTest
class DataSyncSchedulerTest {
    @Autowired
    private queryController queryController;

    // 查询增量客户数据
    @Test
    public void syncOrders1() {
        try {
            queryController.queryCustomer("customerQuery.graphql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 查询增量订单数据
    @Test
    public void syncOrders2() {
        try {
            queryController.queryOrder("orderQuery.graphql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 查询增量货物数据
    @Test
    public void syncOrders3() {
        try {
            queryController.queryProduct("productQuery.graphql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}