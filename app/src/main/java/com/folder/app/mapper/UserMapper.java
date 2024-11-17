package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.folder.app.dto.UserDTO;

@Mapper
public interface UserMapper {
    
    //사용자 조회
    @Select("select * from user")
    public List<UserDTO> selectUser();
}