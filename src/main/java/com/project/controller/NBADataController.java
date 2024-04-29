package com.project.controller;

import com.project.common.BaseResponse;
import com.project.model.NBAGameData;
import com.project.service.impl.NBAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class NBADataController {

    @Autowired
    private NBAService nbaService;

    @GetMapping("/nba/games")
    public BaseResponse<NBAGameData> getNBAGames() {

        return nbaService.getNBAGames();
    }
}
