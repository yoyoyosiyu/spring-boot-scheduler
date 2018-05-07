package com.huayutech.springbootschedule.jpa;

import com.huayutech.springbootschedule.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    Page<Order> findAllByStoreName(@Param("store_name") String name, Pageable pageable);
}
