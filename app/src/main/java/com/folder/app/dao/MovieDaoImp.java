package com.folder.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.folder.app.dto.MovieDTO;
import com.folder.app.mapper.MovieMapper;

@Repository
public class MovieDaoImp implements MovieDao {
    @Autowired
    MovieMapper movieMapper;

    @Override
      public List<MovieDTO>selectMovie(){
        return movieMapper.selectMovie();
    }
}
