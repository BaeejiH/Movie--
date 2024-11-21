package com.folder.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folder.app.dto.MovieDTO;
import com.folder.app.dto.ResultDTO;
import com.folder.app.service.MovieService;

@CrossOrigin(origins = "http://localhost:8800")
@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String Movie() {
        return "Data............";
    }

    @PostMapping("/movieList")
    public ResultDTO MovieList() {
        return movieService.selectMovie();
    }

    @GetMapping("/main")
    public String Main() {
        return new String();
    }

    @GetMapping("/Sub")
    public String Sub() {
        return new String();
    }

    @PostMapping("/AddMovie")
    public ResultDTO insertMovie(@RequestBody MovieDTO movieDTO) {
        try {
            movieService.AddMovie(movieDTO);

            ResultDTO resultDTO = new ResultDTO(true, "영화생성 성공");
            return resultDTO;
        } catch (Exception e) {
            ResultDTO resultDTO = new ResultDTO(false, "영화생성 실패");
            return resultDTO;
        }
    }
}


