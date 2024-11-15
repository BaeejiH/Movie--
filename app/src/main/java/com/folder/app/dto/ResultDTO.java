package com.folder.app.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private  Boolean state;
    private Object result;
    private String message;

    // 기본 생성자
    public ResultDTO() {}

    // 모든 필드를 초기화하는 생성자
    public ResultDTO(Boolean state, String message) {
        this.state = state;
        this.message = message;
    }

    public ResultDTO(Boolean state, Object result, String message) {
        this.state = state;
        this.result = result;
        this.message = message;
    }
}
