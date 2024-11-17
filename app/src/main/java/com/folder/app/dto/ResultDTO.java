package com.folder.app.dto;

import lombok.Data;
// sevice계층과 컨트로러 간에 데이터 교환 용도
// ResultDTO --> 클라이언트 서버 간의 응답 형식을 표준화하는 데 유용   
// 서버의 응답형식을 표준화하고, 요청 처리 결과를 클라이언트가 쉽게 처리할 수 있도록 도와주는 객체.  
@Data
public class ResultDTO {
    private  Boolean state; // 요청 처리 결과 (성공/실패)
    private Object result; // 요청에 대한 실제 데이터 (ex사용자 정보,list)
    private String message; // 처리 결과에 대한 설명 (성공 메세지, 에러 메세지)

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
