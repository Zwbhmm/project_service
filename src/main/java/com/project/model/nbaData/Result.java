package com.project.model.nbaData;

import com.project.model.NBAGameData;
import lombok.Data;

import java.util.List;

@Data
public  class Result{
    private String title;
    private String duration;
    private List<Match> matchs;
}