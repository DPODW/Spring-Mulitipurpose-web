package com.multipurpose.web.vo.boardvo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Board {


    private Integer number;


    private String id;


    private String title;

    
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
