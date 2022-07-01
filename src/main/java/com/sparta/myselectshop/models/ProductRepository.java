package com.sparta.myselectshop.models;

// 프로젝트에서 멤버변수의 생성, 조회, 삭제 기능을 담당할 Java Interface

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // @Entity
    // public class Product
    // extends Timestamped
}
