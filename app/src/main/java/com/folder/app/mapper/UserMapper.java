package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.folder.app.dto.BorrowDTO;
import com.folder.app.dto.UserDTO;

@Mapper
public interface UserMapper {

    //사용자 조회
    @Select("select * from user")
    public List<UserDTO> selectUser();

    //사용자 아이디로 비밀번호 조회
    @Select("SELECT t2.userPw "
            + "FROM USER AS t "
            + "JOIN userPw t2 "
            + "ON t.userId = t2.userId "
            + "WHERE t.userId = #{userId}")
    public String getuserPwByuserId(String userId);

    // 사용자 대여 장바구니 조회
    @Select("SELECT * FROM borrow")
    List<BorrowDTO> selectBorrow();
}
