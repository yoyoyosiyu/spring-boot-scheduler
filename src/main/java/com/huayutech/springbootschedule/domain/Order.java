package com.huayutech.springbootschedule.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "kgl_order")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    protected Long id;

    @Column(name = "order_sn")
    protected String sn;

    @Column(name = "store_name")
    protected String storeName;

    @Column(name = "store_id")
    protected Long storeId;

}
