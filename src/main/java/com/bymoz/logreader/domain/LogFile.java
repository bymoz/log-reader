package com.bymoz.logreader.domain;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Data
@Entity
public class LogFile {
    
    @Id
    private int id;

    private LocalDateTime readDate;

    private String fileName;

}
