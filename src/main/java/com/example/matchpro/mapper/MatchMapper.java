package com.example.matchpro.mapper;

import com.example.matchpro.dto.match.MatchRequest;
import com.example.matchpro.dto.match.MatchResponse;
import com.example.matchpro.model.Match;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ResultMapper.class, StageMapper.class, TeamMapper.class})
public interface MatchMapper extends BaseMapper<Match, MatchResponse> {

    @Mapping(target = "visitorTeam", source = "visitors.name")
    @Mapping(target = "result", source = "results.name")
    @Mapping(target = "localTeam", source = "locals.name")
    @Mapping(target = "id", source = "matchId")
    @Mapping(target = "date", source = "matchDate", dateFormat = "dd-MM-yyyy")
    MatchResponse toResponse(Match entity);

    @Mapping(target = "matchId", ignore = true)
    @Mapping(target = "visitors", source = "visitorTeamId")
    @Mapping(target = "stages", source = "stageId")
    @Mapping(target = "results", source = "resultId")
    @Mapping(target = "locals", source = "localTeamId")
    Match toEntity(MatchRequest request);

}
