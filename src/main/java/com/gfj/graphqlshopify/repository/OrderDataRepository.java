package com.gfj.graphqlshopify.repository;

import com.gfj.graphqlshopify.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author gefangjie
 * @data 2025/1/8 10:07
 */
@Repository
public interface OrderDataRepository extends JpaRepository<OrderData, Long> {

}
