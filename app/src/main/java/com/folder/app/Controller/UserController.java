package com.folder.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserLoginDTO;
import com.folder.app.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    // 사용자 명단
    @PostMapping("/user")    
@CrossOrigin(origins = "http://localhost:8800")
    public ResultDTO selectUser() {
        return userService.selectUser();
    }

    // 사용자 로그인
    @PostMapping("/")   
    @CrossOrigin(origins = "http://localhost:8800")
    public ResultDTO checkId(@RequestBody UserLoginDTO loginDTO) {
        boolean isAuthenticated = userService.authenticateUser(loginDTO.getUserId(), loginDTO.getUserPw());

        if (isAuthenticated) {
            return new ResultDTO(true, "로그인 성공", null);
        } else {
            return new ResultDTO(false, "로그인 실패", null);
        }

    }

}
