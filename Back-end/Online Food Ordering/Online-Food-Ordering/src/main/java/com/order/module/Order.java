package com.order.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.order.module.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User customer;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private double totalAmount;

    private String orderStatus;

    private Date createAt;

    @ManyToOne
    private Address deliverAddress;

    @OneToMany
    private List<OrderItem> orderItems;

    private int totalItem;

    private double totalPrice;

//    private Payment payment;

}
