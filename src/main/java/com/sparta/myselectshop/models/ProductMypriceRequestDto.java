package com.sparta.myselectshop.models;

// 사용자가 설정한 관심상품의 가격을 '변경'하기 위한 정보를 몰고 다니는 DTO 클래스

import lombok.Getter;

@Getter

public class ProductMypriceRequestDto {
    private int myprice;
}
