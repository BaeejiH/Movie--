package com.folder.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.ResultDTO;
import com.folder.app.service.MovieService;



@CrossOrigin(origins="http://localhost:8800")
@RestController
public class MovieController {

    @Autowired MovieService movieService;

    @GetMapping("/")
    public String Movie() {
        return "Data............";
    }

    @PostMapping("/main")
    public ResultDTO findAll(){
        return movieService.selectMovie();
    }
    
}
