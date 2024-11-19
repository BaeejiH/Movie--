package com.folder.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.UserDao;
import com.folder.app.dto.ResultDTO;
import com.folder.app.dto.UserDTO;

@Service
public class UserServiceImp implements UserService {
    private ResultDTO resultDTO;

    @Autowired
    UserDao userDao;

    @Override
    public ResultDTO selectUser() {
        resultDTO = new ResultDTO();
        List<UserDTO> resultList = userDao.selectUser();
        System.out.println("UserList: " + resultList); // 결과 로깅
        if (resultList != null) {
            resultDTO.setState(true);
            resultDTO.setResult(resultList);
        } else {
            resultDTO.setState(false);
        }

        return resultDTO;
    }
    @Override
    public ResultDTO authenticateUser(String userId, String userPw) {
        resultDTO = new ResultDTO();
        // userId를 사용하여 비밀번호 조회
        String storedPassword = userDao.getuserPwByuserId(userId);
        
        System.out.println("storedPassWord");
        if (storedPassword == null) {
            resultDTO.setState(false);
            resultDTO.setResult("아이디가 존재하지 않습니다.");
            System.out.println("DB에서 반환된 비밀번호: " + storedPassword);
         
        } else if (!storedPassword.trim().equals(userPw.trim())) {
            // 저장된 비밀번호가 쿼리로의 select 로인해서 사용자 id로 반환되는 오류
            // mapper의 쿼리부분에 t.userId제거 후 로그인 성공 --> 저장된 비밀번호가 올바른 값으로 나옴
            // 인코딩 불일치 mariaDB애 저장된 비밀번호 인코딩 값과 사용자가 입력하는 비밀번호 인코딩이 불일치 함. --> Db인코딩 변경
            resultDTO.setState(false);
            System.out.println("xxxxxxx");
            resultDTO.setResult("비밀번호가 틀렸습니다.");
            System.out.println("비밀번호가 틀렸습니다. 입력된 비밀번호: " + userPw + ", 저장된 비밀번호: " + storedPassword);
        } else {
            resultDTO.setState(true);
            resultDTO.setResult("로그인 성공");
        }
    
        return resultDTO;
    }
}
