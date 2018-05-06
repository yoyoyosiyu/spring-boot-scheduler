package com.huayutech.springbootschedule.rest;

import com.huayutech.springbootschedule.domain.Product;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.huayutech.springbootschedule.exception.NotFoundException;
import com.huayutech.springbootschedule.jpa.ProductRepository;
import com.huayutech.springbootschedule.resource.ProductResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    protected ProductRepository productRepository;

    @RequestMapping("/{productId}")
    public HttpEntity<ProductResource> doGet(@PathVariable Long productId) throws NotFoundException{

        Optional<Product> product = productRepository.findById(productId);

        if (!product.isPresent()) {
            throw new NotFoundException(String.format("Could not find product with id: %s", productId));
        }

        ProductResource productResource = new ProductResource(product.get());
        productResource.add(linkTo(methodOn(ProductController.class).doGet(productId)).withSelfRel());

        return new ResponseEntity<>(productResource, HttpStatus.OK);
    }

}
