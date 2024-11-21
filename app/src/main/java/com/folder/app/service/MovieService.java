package com.folder.app.service;

import com.folder.app.dto.MovieDTO;
import com.folder.app.dto.ResultDTO;

public interface MovieService {
  public ResultDTO selectMovie();

  public ResultDTO AddMovie(MovieDTO movieDTO);

  public ResultDTO deleteMovie(int movie_num);
}
