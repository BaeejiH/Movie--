package com.folder.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BorrowDTO {
    private int borrow_id;
    private int movie_num;
    private int bcode;
    private String title;
    private Date borrowDate;
}
