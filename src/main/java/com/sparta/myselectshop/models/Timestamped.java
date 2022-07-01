package com.sparta.myselectshop.models;

// 실시간으로 생성시간 및 수정시간을 반영해주기 위한 기능을 수행하는 Java Class
// Timestamped 를 상속받아 써야하기 때문에 추상클래스로 만들어준다.

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // Get 메서드를 자동으로 생성: Read
@MappedSuperclass // createAt, modifiedAt 이 상속받은 클래스에서 멤버변수 (컬럼)이 되어야 한다.
@EntityListeners(AuditingEntityListener.class) // class 가 변경되었을 때 자동으로 recording

public abstract class Timestamped {
    @CreatedDate
    // 최초 생성 시점
    private LocalDateTime createAt;

    @LastModifiedDate
    // 최종 변경 시점
    private LocalDateTime modifiedAt;
}
