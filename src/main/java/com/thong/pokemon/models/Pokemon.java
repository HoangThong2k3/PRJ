package com.thong.pokemon.models;

import com.google.gson.Gson;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    private String name;
    private String type;

    public String toJson() {
        //use gson to convert object to json
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
