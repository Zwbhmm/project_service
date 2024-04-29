package com.project.model.nbaData;

import lombok.Data;

import java.util.List;

@Data
public class Match {
    private String date;
    private String week;
    private List<NBAGame> list;
}
