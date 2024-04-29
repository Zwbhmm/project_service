package com.project.model.nbaData;

import lombok.Data;

@Data
public class NBAGame {
    private String time_start;
    private String status;
    private String status_text;
    private String team1;
    private String team2;
    private String team1_score;
    private String team2_score;
}
