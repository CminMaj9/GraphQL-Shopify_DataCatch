package com.gfj.graphqlshopify.repository;

import com.gfj.graphqlshopify.model.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author gefangjie
 * @data 2025/1/10 16:13
 */
@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {

}
