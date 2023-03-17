package com.bymoz.logreader.dto;

import java.util.List;

import lombok.Data;

@Data
public class GetAllReq {

    private Integer size;
    
    private Integer page;

    private String sortBy;
    
    private String sortDir;

    private List<SearchColumn> searchParam;

}