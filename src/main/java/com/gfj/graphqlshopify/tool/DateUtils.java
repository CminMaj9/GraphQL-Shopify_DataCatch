package com.gfj.graphqlshopify.tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author gefangjie
 * @data 2025/1/8 10:38
 */

public class DateUtils {

    public static String[] getTwoDaysRange() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime twoDaysAgoStart = now.minusDays(2).toLocalDate().atStartOfDay();
        LocalDateTime twoDaysAgoEnd = twoDaysAgoStart.plusDays(2).minusSeconds(1);

        // 使用 DateTimeFormatter 格式化为 "yyyy-MM-dd'T'HH:mm:ss'Z'"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String start = twoDaysAgoStart.format(formatter);
        String end = twoDaysAgoEnd.format(formatter);

        return new String[]{start, end};
    }


    public static void main(String[] args) {
        String[] dateRange = getTwoDaysRange();
        System.out.println("Start Date: " + dateRange[0]);
        System.out.println("End Date: " + dateRange[1]);
    }
}