package com.folder.app.service;

import com.folder.app.dto.ResultDTO;

public interface UserService {
    public ResultDTO selectUser();

    boolean authenticateUser(String userName, String userPw);
}
