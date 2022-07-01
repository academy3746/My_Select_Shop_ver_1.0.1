package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.models.ItemDto;
import com.sparta.myselectshop.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// 키워드 입력 → 검색결과 반환 (자동응답기)
// Return as JSON
@RequiredArgsConstructor
// 여기에 파이널로 선언된 생성자 있다..
// private final NaverShopSearch naverShopSearch;
// @Component: ㅇㅋ...

public class SearchRequestController {
    private final NaverShopSearch naverShopSearch;
    // NaverShopSearch 클래스를 가져다쓰지 않으면 넌 죽는다.
    // @Component 올림..

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query){
        // @RequestParam: JSON 형식으로 날라오는 query 변수를 파라미터 값으로 List<ItemDto>에 저장하겠음
        // "api/search ?query=검색어"
        // doGet(request, response);
        String result = naverShopSearch.search(query);
        // 일해라, 핫싼..!

        return naverShopSearch.fromJSONtoItems(result);
        // From JSON to ItemDto ArrayList<>
    }
}
