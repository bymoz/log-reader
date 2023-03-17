package com.bymoz.logreader.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class SearchColumn {

    private String column;

    private Object value;
    
    private String type;

    private String operator;

    public SearchColumn(String column, Object value, String type) {
        this.column = column;
        this.value = value;
        this.type = type;
    }
}
