package com.sparta.myselectshop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // Get Method 자동 생성
@NoArgsConstructor // 기본생성자
@Entity // 클래스가 DB 서버에서 테이블의 역할 수행함을 Java 에게 주지

public class Product extends Timestamped {
     /* Table No: Long id
      * 상품 이름: String title
      * 상품 이미지: String image
      * 상품 링크: String link
      * 상품 최저가: String lprice
      * 설정 최저가: String myprice
      */

    @Id // Table No.
    @GeneratedValue(strategy = GenerationType.AUTO) // Id++;
    private Long id;

    @Column(nullable = false)
    // This Table Column must have value!
    private String title;

    @Column(nullable = false)
    // This Table Column must have value!
    private String image;

    @Column(nullable = false)
    // This Table Column must have value!
    private String link;

    @Column(nullable = false)
    // This Table Column must have value!
    private int lprice;

    @Column(nullable = false)
    // This Table Column must have value!
    private int myprice;

    // 사용자의 관심상품 등록 (POST)
    public Product(ProductRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.link = requestDto.getLink();
        this.image = requestDto.getImage();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
        // 해당 칼럼 역시 값이 반드시 존재해야 하므로 default 값 (0)이라도 설정을 해줘야 한다.
        // lprice < myprice 일 때만 최저가 정보가 떠야 한다.
    }

    // 사용자가 설정한 관심상품의 가격 (myprice) 변경 (PUT)
    public void update(ProductMypriceRequestDto requestDto){
        this.myprice = requestDto.getMyprice();
    }

    public void updateByItemDto(ItemDto itemDto) {
        this.lprice = itemDto.getLprice();
    }
}
