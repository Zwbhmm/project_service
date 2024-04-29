package com.project.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.model.nbaData.Result;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class NBAGameData implements Serializable {
    private String reason;
    private Result result;
    private int error_code;
}

