package com.sparta.myselectshop.models;

// 전달받은 itemJson 데이터를 클라이언트에게 되돌려주기 위한 별도의 Dto 클래스!

import lombok.Getter;
import org.json.JSONObject;

@Getter
// @Setter: ItemDto 생성자에서 필요한 정보만 꺼내다가 쓸 것이기 때문에 Setter 는 따로 필요하지 않음

public class ItemDto {
    private String title;
    private String image;
    private String link;
    private int lprice;

    // Get JSONObject to transfer items of JSON Array
    public ItemDto(JSONObject itemJson){
        this.title = itemJson.getString("title");
        // Key (Value) is title.
        this.image = itemJson.getString("image");
        // Key (Value) is image.
        this.link = itemJson.getString("link");
        // Key (Value) is link.
        this.lprice = itemJson.getInt("lprice");
        // Key (Value) is lprice.
    }
}
