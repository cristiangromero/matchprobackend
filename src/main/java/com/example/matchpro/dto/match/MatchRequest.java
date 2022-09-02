package com.example.matchpro.dto.match;

import com.example.matchpro.dto.result.ResultRequest;
import com.example.matchpro.dto.stadium.StadiumRequest;
import com.example.matchpro.dto.stage.StageRequest;
import com.example.matchpro.dto.team.TeamRequest;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchRequest {
    private Date matchDate;
    private String status;
    private StadiumRequest stadium;
    private StageRequest stage;
    private ResultRequest result;
    private TeamRequest visitorTeam;
    private TeamRequest localTeam;
}
