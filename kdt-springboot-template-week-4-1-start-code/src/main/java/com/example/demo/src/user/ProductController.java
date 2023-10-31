package com.example.demo.src.user;


import com.example.demo.common.BaseException;
import com.example.demo.common.BaseResponse;
import com.example.demo.src.user.model.GetProductRes;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

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
