package com.sparta.myselectshop.utils;

import com.sparta.myselectshop.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
/* @RequiredArgsConstructor
 * @NoArgsConstructor
 * @Entity
 * @Service
 * ...
 * */

public class NaverShopSearch {
    // Step01: 검색 키워드 (query) 를 문자열 (JSON) 형태로 Get
    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "joewLaLti4xv_gnC5SKz");
        headers.add("X-Naver-Client-Secret", "C1q56mPWva");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange
                ("https://openapi.naver.com/v1/search/shop.json?query=" + query,
                        HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    // Step02: JSON 데이터를 ItemDto 로 반환
    public List<ItemDto> fromJSONtoItems(String result){
        JSONObject rjson = new JSONObject(result);
        JSONArray items = rjson.getJSONArray("items");

        List<ItemDto> itemDtoList = new ArrayList<>();
        // 필요한 정보를 하나만 노출시켜 주는 것이 아니라 여러개 불러오기 위해 배열 사용..
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = (JSONObject) items.get(i);
            ItemDto itemDto = new ItemDto(itemJson);
            // Insert itemJson to itemDto Object.
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }
}