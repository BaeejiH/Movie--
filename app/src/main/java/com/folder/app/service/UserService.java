package com.folder.app.service;

import com.folder.app.dto.ResultDTO;

public interface UserService {
    public ResultDTO selectUser();
    ResultDTO authenticateUser(String userId, String userPw);  // 반환 타입을 boolean에서 ResultDTO로 변경
}

