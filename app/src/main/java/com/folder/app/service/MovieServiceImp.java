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
}
