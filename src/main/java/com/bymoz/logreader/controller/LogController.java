package com.bymoz.logreader.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bymoz.logreader.dto.ResponseDto;
import com.bymoz.logreader.service.LogService;

@RestController
@RequestMapping("/log")
public class LogController {
    
    @Autowired
    private LogService logService;

    @GetMapping("/hello")
    public ResponseDto hello() {
        ResponseDto response = new ResponseDto();
        response.setStatus(200);
        response.setMessage("Log Reader is Running!");
        response.setTimestamp(LocalDateTime.now());
        response.setData(logService.getLogFileList());

        return response;
    }

}
