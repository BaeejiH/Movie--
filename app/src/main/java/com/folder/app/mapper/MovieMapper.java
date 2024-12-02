package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.folder.app.dto.MovieDTO;

@Mapper
public interface MovieMapper {

    // 영화 data 조회
    @Select("select * from Movie")
    List<MovieDTO> selectMovie();

    // 영화 생성
    @Insert(" INSERT INTO movie (genre, title, directore, producer, release_date, runtime, description, bcode) VALUES (#{genre}, #{title}, #{directore}, #{producer}, #{release_date}, #{runtime}, #{description}, #{bcode});")
    int insertMovie(MovieDTO movieDTO);

    // 영화 삭제
    @Delete("DELETE FROM MOVIE WHERE movie_num = #{movie_num}")
    int deleteMovie(int movie_num);

    //영화 수정
    @Update("UPDATE movie " +
               "SET genre = #{genre}, " +
               "    title = #{title}, " +
               "    directore = #{directore}, " +
               "    producer = #{producer}, " +
               "    release_date = #{release_date}, " +
               "    runtime = #{runtime}, " +
               "    description = #{description}, " +
               "    bcode = #{bcode} " +
             "WHERE movie_num = #{movie_num}")
    int updateMovie(MovieDTO movieDTO);


}
