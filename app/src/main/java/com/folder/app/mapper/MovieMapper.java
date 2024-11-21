package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.folder.app.dto.MovieDTO;

@Mapper
public interface MovieMapper {

    // 영화 data 조회
    @Select("select * from Movie")
    List<MovieDTO> selectMovie();

    // 영화 생성
    @Insert(" INSERT INTO movie (genre, title, directore, producer, release_date, runtime, description, bcode) VALUES (#{genre}, #{title}, #{directore}, #{producer}, #{release_date}, #{runtime}, #{description}, #{bcode});")
    int insertMovie(MovieDTO movieDTO);
}
