package com.example.matchpro.dto.match;

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
    private long stadiumId, stageId, resultId, visitorTeamId, localTeamId;
}
