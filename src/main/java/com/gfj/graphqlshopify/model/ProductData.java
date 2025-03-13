package com.gfj.graphqlshopify.model;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import java.time.LocalDateTime;

/**
 * @Author gefangjie
 * @data 2025/1/9 16:52
 */


@NoArgsConstructor
@Data
@Entity
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private String responseData;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    public ProductData(String responseData, LocalDateTime createdAt) {
        this.responseData = responseData;
        this.createdAt = createdAt;
    }
}