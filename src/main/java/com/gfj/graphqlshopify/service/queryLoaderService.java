package com.gfj.graphqlshopify.service;

import com.gfj.graphqlshopify.tool.DateUtils;
import com.gfj.graphqlshopify.tool.GraphQLQueryLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author gefangjie
 * @data 2025/1/9 16:58
 */
@Service
// 用于加载 GraphQL 查询模板进行查询
public class queryLoaderService {

    @Autowired
    private GraphQLQueryLoader queryLoader;

    // 从本地加载 GraphQL 查询模板
    public String getQueryLastTwoDays(String fileName) throws IOException {
        // 获取前两天的日期范围
        String[] dateRange = DateUtils.getTwoDaysRange();
        String startDate = dateRange[0];
        String endDate = dateRange[1];

        // 加载 GraphQL 查询模板
        String queryTemplate = queryLoader.loadQueryJar(fileName);

        // 替换模板中的占位符
        String query = queryTemplate.replace("$startDate", startDate).replace("$endDate", endDate);

        System.out.println("接下来是最终的查询\n"+query);

        // 输出最终的查询
        return query;
    }
}
