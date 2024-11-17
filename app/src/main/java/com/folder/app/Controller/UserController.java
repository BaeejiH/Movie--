package com.folder.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.ResultDTO;
import com.folder.app.service.UserService;


@CrossOrigin(origins="http://localhost:8800")
@RestController
public class UserController {

    @Autowired
    UserService userService;

   @PostMapping("/user")
   public ResultDTO selectUser() {
        return userService.selectUser();
   }
   


}
