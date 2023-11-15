package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetProductRes {
    private int productId;
    private String productName;
    private String productPrice;
    private int seller_sellerid;
    private String productComment;
    private String productPhone;

}
