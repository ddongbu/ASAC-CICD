package com.example.demo.src.user;


import com.example.demo.common.BaseException;
import com.example.demo.common.BaseResponse;
import com.example.demo.src.user.model.GetProductRes;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
//@NoArgsConstructor
//@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    //private final ProductService productService -> @FieldDefaults(makeFinal = true,level= AccessLevel.PRIVATE)
    ProductService productService;

    @ResponseBody
    @GetMapping("/{productId}") // (GET) 127.0.0.1:9000/api/products/:productId
    public BaseResponse<GetProductRes> getProductDeatilById(@PathVariable("productId") int productId) {
        // Get Users
        try{
            GetProductRes getProductRes = productService.getProductDeatilById(productId);
            return new BaseResponse<>(getProductRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }



//    @ResponseBody
//    @PostMapping("/{productId}/admin/productdetail")
//    public BaseResponse<GetProductRes> insertProductDetail(PostAdminProductRes postAdminProductRes)
}
