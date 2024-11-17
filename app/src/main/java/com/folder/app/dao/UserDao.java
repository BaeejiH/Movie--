package com.folder.app.dao;

import java.util.List;

import com.folder.app.dto.UserDTO;


public interface UserDao {
     public List<UserDTO>selectUser();
}
