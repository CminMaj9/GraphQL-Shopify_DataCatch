package com.gfj.graphqlshopify.repository;

import com.gfj.graphqlshopify.model.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author gefangjie
 * @data 2025/1/9 16:55
 */
@Repository
public interface ProductDataRepository extends JpaRepository<ProductData, Long> {

}
