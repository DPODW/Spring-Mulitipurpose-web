package com.multipurpose.web.vo.boardvo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class board {


    private int number;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min=3, max= 30)
    private String title;

    @NotBlank
    @Size(min=5, max= 100)
    private String content;

    public board(int number, String name, String title, String content) {
        this.number = number;
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
