package com.folder.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @DeleteMapping("/movieList/{movie_num}")
    // @PathVariable : Http요청 url경로에 포함된 값을 메소드 매개변수에 자동으로 바인딩해줌.
    // 주로 RESTful 웹 서비스에서 URL 경로의 일부분을 동적으로 처리할 때 사용함.
    // id나 name 같은 파라미터 값을 받아와서 해당 값을 사용하고자 할 때 유용. ex) movie_num 파라미터의 값을 받아와 영화삭제에 사용할 때
    public ResultDTO deleteMovie(@PathVariable int movie_num) {
        ResultDTO result = movieService.deleteMovie(movie_num);
        return result;
    }

    @PutMapping("movieList/{movie_num}")
    public ResultDTO updateMovie(@PathVariable int movie_num, @RequestBody MovieDTO movieDTO) {
        try {
            movieDTO.setMovie_num(movie_num); // URL에서 받은 movie_num을 movieDTO에 설정, @pathVariable은 url경로에서 변수를 바인딩 해주기 때문에 같이 써야함.
            movieService.updateMovie(movieDTO); // 영화 수정 서비스 호출
    
            return new ResultDTO(true, "영화 수정 성공");
        } catch (Exception e) {
            return new ResultDTO(false, "영화 수정 실패");
        }
    }
}


