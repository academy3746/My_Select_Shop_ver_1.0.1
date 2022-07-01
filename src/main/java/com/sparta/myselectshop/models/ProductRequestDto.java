package com.sparta.myselectshop.models;

// 관심상품을 등록하기 위해 필요한 정보를 몰고 다니는 DTO Class
// Required Member Variable: 상품의 품명, 이미지, 최저가, 네이버 쇼핑 링크

import lombok.Getter;

@Getter

public class ProductRequestDto {
    private String title;
    private String link;
    private String image;
    private int lprice;
}
