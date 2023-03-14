package com.bymoz.logreader.domain;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Data
@Entity
public class LogData {
    
    @Id
    private int id;

    private int logFileId;

    private LocalDateTime logDate;

    private String logSeverity;

    private String logClass;

    private String logThread;

    private String logMessage;

    private String logStacktrace;

}
