package com.gfj.graphqlshopify.tool;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @Author gefangjie
 * @data 2025/1/7 15:37
 */
// 工具类：加载 GraphQL 查询文件
@Component
public class GraphQLQueryLoader {

    // 本地加载方法
    public static String loadQueryLocal(String fileName) {

        try {
            // 从 resources/graphql 目录加载 GraphQL 查询
            Path path = new ClassPathResource("graphql/" + fileName).getFile().toPath();
            return Files.readString(path);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load GraphQL query: " + fileName, e);
        }
    }

    // Jar 包加载方法
    public static String loadQueryJar(String fileName) throws IOException {
        // 1. 从 resources/graphql 目录加载 GraphQL 查询
        InputStream inputStream = new ClassPathResource("graphql/" + fileName).getInputStream();
        // 2. 如果加载失败，抛出异常
        if (inputStream == null) {
            throw new RuntimeException("Failed to load GraphQL query: " + fileName);
        }
        // 3. 读取文件内容
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // 4. 读取文件内容并返回
            StringBuilder content = new StringBuilder();
            // 5. 逐行读取文件内容
            String line;
            // 6. 读取文件内容
            while ((line = reader.readLine()) != null) {
                // 7. 拼接文件内容
                content.append(line).append("\n");
            }
            // 8. 返回文件内容
            return content.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load GraphQL query: " + fileName, e);
        }
    }

}
