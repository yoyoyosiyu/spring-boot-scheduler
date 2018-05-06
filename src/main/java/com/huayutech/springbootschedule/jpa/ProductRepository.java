package com.huayutech.springbootschedule.jpa;


import com.huayutech.springbootschedule.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource()
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @RestResource(exported = false)
    List<Product> findAllByIdGreaterThanAndUpdateAtIsGreaterThanEqual(@Param("productId") Long id, @Param("updateAt") Long updateAt);

    @RestResource(path="name")
    List<Product> findAllByNameContaining(@Param("name") String name);

    @RestResource(path = "commonId")
    List<Product> findAllByCommondId(@Param("commonId") Long commonId);

}
