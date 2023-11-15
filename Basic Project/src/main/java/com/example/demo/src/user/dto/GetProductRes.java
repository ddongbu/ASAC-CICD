package com.example.demo.src.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetProductRes {
    private Integer product_id;
    private String product_name;
    private String product_price;
    private String product_comment;
    private String product_phone;
}
