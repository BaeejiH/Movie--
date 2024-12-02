package com.folder.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.BorrowDTO;
import com.folder.app.dto.UserDTO;
import com.folder.app.mapper.UserMapper;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDTO>selectUser(){
        return userMapper.selectUser();
    }

    @Override
    public String getuserPwByuserId (String userId){
        // 설계오류
        // 사용자 이름으로 조회하는게 아니라 로그인시 아이디와 비밀번호를 조회해야함.
        // 사용자 이름으로 로그인을 시도하려다 보니 오류
        // 쿼리와 dao 모두 userName을 userId로 변경
        return userMapper.getuserPwByuserId(userId);
    }

    @Override
    public List<BorrowDTO>selectBorrow(){
        return userMapper.selectBorrow();
    }
}
