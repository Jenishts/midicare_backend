package com.medicare.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Medicare")
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "Product_Name", nullable = false)
    private String productName;

    @Column(name = "Product_Description", nullable = false)
    private String productDescription;


    @Column(name = "Product_Price", nullable = false)
    private Double price;

    @Column(name = "Product_Image")
    private String imageURL;

    @Column(name = "Seller_Name", nullable = false)
    private String seller;

    @Column(name = "Offer_Price", nullable = false)
    private Double discountPrice;

    @Column(name = "In_Stock", nullable = false)
    private boolean productAvailability=true;

}
