package com.bymoz.logreader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bymoz.logreader.domain.LogData;

public interface LogDataRepository extends JpaRepository<LogData, Integer> {

}
