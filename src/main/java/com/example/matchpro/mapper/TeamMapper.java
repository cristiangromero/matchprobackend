package com.example.matchpro.mapper;

import com.example.matchpro.dto.team.TeamRequest;
import com.example.matchpro.dto.team.TeamResponse;
import com.example.matchpro.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper extends BaseMapper<Team, TeamResponse> {

    @Mapping(target = "id", source = "teamId")
    TeamResponse toResponse(Team entity);

    @Mapping(target = "matches", ignore = true)
    @Mapping(target = "visitorMatches", ignore = true)
    @Mapping(target = "teamId", ignore = true)
    @Mapping(target = "localMatches", ignore = true)
    Team toEntity(TeamRequest request);

}
