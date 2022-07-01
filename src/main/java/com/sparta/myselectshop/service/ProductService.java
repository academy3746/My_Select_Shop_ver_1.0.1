package com.sparta.myselectshop.service;
import com.sparta.myselectshop.models.Product;
import com.sparta.myselectshop.models.ProductMypriceRequestDto;
import com.sparta.myselectshop.models.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service // Hey, Java! This class is Service Application!

// 관심상품의 가격정보를 변경해주기 위한 '기능'을 수행하는 서비스 객체

public class ProductService {

    private final ProductRepository productRepository;
    // 조회 (SELECT) 기능을 수행하기 위해 productRepository 를 받아와야 한다.

    @Transactional
    // pstmt.updateQuery();
    public void update(Long id, ProductMypriceRequestDto requestDto){
        // 가격정보를 물어오는 ProductMypriceRequestDto 를 받아와야 한다.
        Product product = productRepository.findById(id).orElseThrow(
                // String sql =  SELECT * FROM PRODUCT WHERE 'ID' LIKE ?;
                //        sql += NVL2();
                () -> new IllegalArgumentException("해당 Id가 존재하지 않습니다!")
        );

        product.update(requestDto);
        // ProductMypriceRequestDto requestDto
        // return id;
    }
}
