package com.folder.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
