package com.folder.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
  private String userId;
  private String userName;
  private String userEmail;
  private String gender;
  private Date updateDate;
  private Date createDate;
  private String userPw;
}
