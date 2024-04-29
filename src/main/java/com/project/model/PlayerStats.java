package com.project.model;


import lombok.Data;

@Data
public class PlayerStats {

    private Integer statId;

    private Integer matchId;

    private String playerName;

    private int minutesPlayed;

    private String fieldGoalsMade;

    private String threePointersMade;

    private String freeThrowsMade;

    private int offensiveRebounds;

    private int defensiveRebounds;

    private int totalRebounds;

    private int assists;

    private int personalFouls;

    private int steals;

    private int turnovers;

    private int blocks;

    private int points;

    private String plusMinus;
}
