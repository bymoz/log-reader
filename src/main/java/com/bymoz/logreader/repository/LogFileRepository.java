package com.bymoz.logreader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bymoz.logreader.domain.LogFile;

public interface LogFileRepository extends JpaRepository<LogFile, Integer> {

}
