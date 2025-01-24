package com.gfj.graphqlshopify.tool;

/**
 * @Author gefangjie
 * @data 2025/1/7 11:18
 */
// GraphQL请求封装类
public class GraphQLRequest {
    private String query;

    public GraphQLRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
