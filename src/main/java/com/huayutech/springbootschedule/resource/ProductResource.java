package com.huayutech.springbootschedule.resource;

import com.huayutech.springbootschedule.domain.Product;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class ProductResource extends ResourceSupport {

    private final Product product;

    public ProductResource(Product product) {

        this.product = product;
    }

}
