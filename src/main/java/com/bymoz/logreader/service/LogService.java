package com.bymoz.logreader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bymoz.logreader.domain.LogData;
import com.bymoz.logreader.domain.LogFile;
import com.bymoz.logreader.repository.LogDataRepository;
import com.bymoz.logreader.repository.LogFileRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {
    
    @Autowired
    private LogFileRepository logFileRepo;
    @Autowired
    private LogDataRepository logDataRepo;

    public List<LogFile> getLogFileList() {
        List<LogFile> result = new ArrayList<>();

        result = logFileRepo.findAll();
        
        return result;
    }

    public List<LogData> getLogDataList(Integer logFileId) {
        List<LogData> result = new ArrayList<>();

        result = logDataRepo.findAll();
        
        return result;
    }
}
