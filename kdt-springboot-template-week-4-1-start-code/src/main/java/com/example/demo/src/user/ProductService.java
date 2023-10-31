package com.example.demo.src.user;


import com.example.demo.common.BaseException;
import com.example.demo.src.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.common.BaseResponseStatus.DATABASE_ERROR;
import static com.example.demo.common.BaseResponseStatus.POST_USERS_EXISTS_EMAIL;

@Service
@RequiredArgsConstructor //생성자
public class ProductService {

    private final ProductDao productDao;

    //GET
    public GetProductRes getProductDeatilById(int productId) throws BaseException{
        try{
            GetProductRes getProductRes = productDao.getProductDeatilById(productId);
            return getProductRes;
        }catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

//    //POST
//    public PostAdminProductRes insertProductDetail(PostAdminProductRes postAdminProductRes) throws BaseException {
//        try{
//            PostAdminProductRes insertedProductDetail = productDao.insertProductDetail(postAdminProductRes);
//            return new PostAdminProductRes(productId);
//        } catch (Exception exception) {
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }
}
