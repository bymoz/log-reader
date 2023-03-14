package com.bymoz.logreader.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseDto {
    
    private int status;

    private String message;

    private LocalDateTime timestamp;

    private Object data;
}
