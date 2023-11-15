package com.example.demo.src.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(nullable = false)
    private String orderitemcount;
    @Column(nullable = false)
    private String orderitemprice;

    @ManyToOne
    @JoinColumn(name="orderId")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;

}
