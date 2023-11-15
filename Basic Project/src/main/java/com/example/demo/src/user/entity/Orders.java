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
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "userId") // 외래 키로 연결할 열의 이름을 지정합니다.
    private User user;
}
