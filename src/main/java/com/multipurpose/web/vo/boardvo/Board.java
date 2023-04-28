package com.multipurpose.web.vo.boardvo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Board {


    private Integer number;

    @NotBlank
    private String id;

    @NotBlank
    @Size(min=3, max= 30)
    private String title;

    @NotBlank
    @Size(min=5, max= 100)
    private String content;

    public Board(Integer number, String id, String title, String content) {
        this.number = number;
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Board(){

    }
}
