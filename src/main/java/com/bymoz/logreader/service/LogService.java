package com.bymoz.logreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bymoz.logreader.domain.LogFile;
import com.bymoz.logreader.repository.LogFileRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {
    
    @Autowired
    private LogFileRepository logFileRepository;

    public List<LogFile> getLogFileList() {
        List<LogFile> result = new ArrayList<>();

        result = logFileRepository.findAll();
        
        return result;
    }
}
