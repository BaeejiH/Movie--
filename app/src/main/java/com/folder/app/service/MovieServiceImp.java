package com.folder.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.app.dao.MovieDao;
import com.folder.app.dto.MovieDTO;
import com.folder.app.dto.ResultDTO;

@Service
public class MovieServiceImp implements MovieService {

    private ResultDTO rDto;

    @Autowired 
    MovieDao movieDao;

    @Override
    public ResultDTO selectMovie(){
         rDto = new ResultDTO();
        List<MovieDTO> resultList = movieDao.selectMovie();
        System.out.println("Retrieved user list: " + resultList); // 결과 로깅
        if(resultList != null){
            rDto.setState(true);
            rDto.setResult(resultList);
        } else{
            rDto.setState(false);
            }
       
        return rDto;
    }

   @Override
    public  ResultDTO AddMovie(MovieDTO movieDTO) {
        rDto = new ResultDTO();
        try {
            int result = movieDao.insertMovie(movieDTO);

            System.out.println("데이터ㅓㅓㅓ터터터터터:"+result);

            if(result>0){
                rDto.setState(true);
                rDto.setMessage("영화생성 성공");
            }else{
                rDto.setState(false);
                rDto.setMessage("영화생성 실패");
            }
        } catch (Exception e) {
            rDto.setState(false);
            rDto.setMessage("Error:"+e.getMessage());
        }
        return rDto;
    }


}
