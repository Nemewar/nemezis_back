package com.cavanosa.TutorialStripe.http;

import lombok.ToString;

@ToString
public class ArticuloDto {

    private int id;

    public ArticuloDto() {
    }

    public ArticuloDto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
