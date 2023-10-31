package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostAdminProductRes {
    private String productComment;
    private String productPhone;
    private int role_id;
    private int products_productId;
}
