package com.huayutech.springbootschedule.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "kgl_goods")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    protected Long id;

    @Column(name = "goods_name")
    protected String name;

    @Column(name="goods_edittime")
    protected Long updateAt;

    @Column(name = "goods_commonid")
    protected Long commondId;

}
