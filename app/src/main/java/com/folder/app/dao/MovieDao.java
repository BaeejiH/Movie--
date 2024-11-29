package com.folder.app.dao;

import java.util.List;

import com.folder.app.dto.MovieDTO;

public interface MovieDao {
      List<MovieDTO>selectMovie();

      int insertMovie (MovieDTO movieDTO);
      int deleteMovie (int movie_num);
      int updateMovie(MovieDTO movieDTO);
}
