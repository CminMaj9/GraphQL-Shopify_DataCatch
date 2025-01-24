package com.gfj.graphqlshopify.service;

import com.gfj.graphqlshopify.model.CustomerData;
import com.gfj.graphqlshopify.model.OrderData;
import com.gfj.graphqlshopify.model.ProductData;
import com.gfj.graphqlshopify.repository.CustomerDataRepository;
import com.gfj.graphqlshopify.repository.OrderDataRepository;
import com.gfj.graphqlshopify.repository.ProductDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @Author gefangjie
 * @data 2025/1/14 09:27
 */
@Service
public class DatabaseService {
    @Autowired
    private OrderDataRepository orderDataRepository;
    @Autowired
    private ProductDataRepository productDataRepository;
    @Autowired
    private CustomerDataRepository customerDataRepository;

    /**
     * 保存数据到数据库
     * @param dataType 数据类型
     * @param response API响应数据
     */
    public <T> void saveData(Class<T> dataType, String response) {

        // 获取当前本地时间（自动使用系统时区）
        LocalDateTime localDateTime = LocalDateTime.now();
        // 转换为 Timestamp 存储到数据库
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(localDateTime);
        // 根据数据类型保存到对应的数据库表
        if (dataType == OrderData.class) {
            OrderData orderData = new OrderData(response, timestamp);
            orderDataRepository.save(orderData);
        } else if (dataType == ProductData.class) {
            ProductData productData = new ProductData(response, timestamp);
            productDataRepository.save(productData);
        } else if (dataType == CustomerData.class) {
            CustomerData customerData = new CustomerData(response, timestamp);
            customerDataRepository.save(customerData);
        }
    }
}
