package com.gfj.graphqlshopify.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;

/**
 * @Author gefangjie
 * @data 2025/1/10 16:06
 */
@Entity
@Data
@NoArgsConstructor
public class CustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private String responseData;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    public CustomerData(String responseData, Timestamp createdAt) {
        this.responseData = responseData;
        this.createdAt = createdAt;
    }
}
