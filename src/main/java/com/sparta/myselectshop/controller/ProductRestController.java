package com.sparta.myselectshop.controller;

/* 1. 관심상품 목록 조회 기능 수행
 * 2. 관심상품 신규 등록 기능 수행
 */

import com.sparta.myselectshop.models.Product;
import com.sparta.myselectshop.models.ProductMypriceRequestDto;
import com.sparta.myselectshop.models.ProductRepository;
import com.sparta.myselectshop.models.ProductRequestDto;
import com.sparta.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // final 로 선언된 멤버변수 자동생성
@RestController // Data Request-Response as JSON Type

public class ProductRestController {

    private final ProductRepository productRepository;
    // POST, PUT, DELETE 기능을 수행하는 ProductRepository Interface 상속
    // Hey, REST CON! This is essentially required method!
    private final ProductService productService;

    // 등록된 전체 상품 목록 조회 (GET)
    @GetMapping("/api/products")
    public List<Product> getProduct(){
        return productRepository.findAll();
        // SELECT * FROM PRODUCT
    }

    // 관심 상품 신규 등록 (POST)
    @PostMapping("/api/products")
    public Product postProduct(@RequestBody ProductRequestDto requestDto){
        // 배열 목록 전체를 업데이트 해줄 필요는 없기 때문에 단일 객체만 선언해주면 된다.
        // 관심상품의 신규 정보를 등록해야 하기 때문에 ProductRequestDto 를 받아온다.
        Product product = new Product(requestDto);
        // ProductRequestDto 내장객체의 정보를 담고 있는 빵을 만들어달라!
        return productRepository.save(product);
        /* productRepository.save(product);
         * return product;
          */
    }

    // 관심상품 최저가 (myprice) 설정 (PUT)
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }
}
