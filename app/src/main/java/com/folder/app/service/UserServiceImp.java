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
    public ResultDTO selectUser(){
         resultDTO = new ResultDTO();
        List<UserDTO> resultList = userDao.selectUser();
        System.out.println("UserList: " + resultList); // 결과 로깅
        if(resultList != null){
            resultDTO.setState(true);
            resultDTO.setResult(resultList);
        } else{
            resultDTO.setState(false);
            }
       
        return resultDTO;
    }   

    @Override
    public boolean authenticateUser(String userName, String userPw) {
        // 데이터베이스에서 사용자 정보를 확인
        String storedPassword = userDao.getuserPwByuserName(userName);
        
        if (storedPassword == null) {
            // 사용자 이름이 존재하지 않으면 false 반환
            return false;
        } else {
              // 비밀번호가 일치하면 true 반환
         return storedPassword.equals(userPw);
        }
    }
}
