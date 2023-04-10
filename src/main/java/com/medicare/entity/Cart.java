package com.medicare.entity;

import com.medicare.usermanager.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @ManyToOne
    private Product product;

}
