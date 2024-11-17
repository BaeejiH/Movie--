package com.folder.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MovieDTO {
    private int movie_num;
    private String genre;
    private String title;
    private String directore;
    private String producer;
    private Date release_date;
    private int runtime;
    private String description;
    private int bcode;

}
