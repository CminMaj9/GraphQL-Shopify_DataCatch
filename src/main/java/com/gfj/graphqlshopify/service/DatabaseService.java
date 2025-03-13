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
import java.time.ZoneId;
import java.time.ZonedDateTime;

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

        // 获取当前时间并指定时区为 Asia/Shanghai (北京时间)
        ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        LocalDateTime localDateTime = shanghaiZonedDateTime.toLocalDateTime();

        System.out.println("当前时间：" + localDateTime);

        // 根据数据类型保存到对应的数据库表
        if (dataType == OrderData.class) {
            OrderData orderData = new OrderData(response, localDateTime);
            orderDataRepository.save(orderData);
        } else if (dataType == ProductData.class) {
            ProductData productData = new ProductData(response, localDateTime);
            productDataRepository.save(productData);
        } else if (dataType == CustomerData.class) {
            CustomerData customerData = new CustomerData(response, localDateTime);
            customerDataRepository.save(customerData);
        }
    }
}
