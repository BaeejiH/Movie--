package com.folder.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserLoginDTO;
import com.folder.app.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:8800")
public class UserController {
    @Autowired
    UserService userService;

    // 사용자 명단
    @PostMapping("/user")    
    public ResultDTO selectUser() {
        return userService.selectUser();
    }

    // 사용자 로그인
    @PostMapping("/api/login")   
    public ResultDTO checkId(@RequestBody UserLoginDTO loginDTO,HttpSession session) {
        // authenticateUser 메소드는 이제 ResultDTO를 반환하므로, 그대로 그 반환값을 사용
        ResultDTO resultDTO = userService.authenticateUser(loginDTO.getUserId(), loginDTO.getUserPw(),session);

        return resultDTO;  // 로그인 결과 그대로 반환
    }

 
}
