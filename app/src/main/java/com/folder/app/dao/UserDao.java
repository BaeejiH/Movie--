package com.folder.app.dao;

import java.util.List;

import com.folder.app.dto.BorrowDTO;
import com.folder.app.dto.UserDTO;


public interface UserDao {
     public List<UserDTO>selectUser();

     public String getuserPwByuserId(String userId);

     public List<BorrowDTO>selectBorrow();
}
