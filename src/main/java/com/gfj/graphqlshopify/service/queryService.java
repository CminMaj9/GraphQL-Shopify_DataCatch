package com.gfj.graphqlshopify.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfj.graphqlshopify.repository.OrderDataRepository;
import com.gfj.graphqlshopify.tool.GraphQLRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;

/**
 * @Author gefangjie
 * @data 2025/1/6 10:46
 */
@Service
public class queryService {

    // 初始化WebClient和其他依赖
    private final WebClient webClient;
    private final queryLoaderService queryLoaderService;

    // 构造函数注入WebClient和其他依赖
    public queryService(WebClient.Builder webClientBuilder,
                        @Value("${shopify.api.url}") String url,
                        @Value("${shopify.api.token}") String token,
                        OrderDataRepository orderDataRepository,
                        queryLoaderService queryLoaderService) {
        // Initialize the WebClient with the base URL and headers
        this.webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("X-Shopify-Access-Token", token)
                .build();
        this.queryLoaderService = queryLoaderService;
    }

    // 方法：获取最近两天的XX数据并保存到数据库
    public String fetchAndSaveDataLastTwoDays(String fileName) throws IOException {

        // GraphQL查询语句
        String query = queryLoaderService.getQueryLastTwoDays(fileName);

        // 包装成 JSON 格式
        String requestBody = new ObjectMapper().writeValueAsString(new GraphQLRequest(query));

        // 进行POST请求，并将响应体转换为String
        try {
            String response = this.webClient.post()
                    // 设置请求体
                    .bodyValue(requestBody)
                    // 发送请求并获取响应
                    .retrieve()
                    // 将响应体转换为String
                    .bodyToMono(String.class)
                    // 阻塞等待响应
                    .block();

            System.out.println("response: " + response);

            return response;

        } catch (WebClientResponseException e) {
            System.err.println("Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while fetching orders", e);
        }
    }
}

