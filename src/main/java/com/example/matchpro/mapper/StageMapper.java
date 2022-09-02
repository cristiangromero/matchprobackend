package com.example.matchpro.mapper;

import com.example.matchpro.dto.stage.StageRequest;
import com.example.matchpro.dto.stage.StageResponse;
import com.example.matchpro.model.Stage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StageMapper extends BaseMapper<Stage, StageResponse> {

    @Mapping(target = "id", source = "stageId")
    StageResponse toResponse(Stage entity);

    @Mapping(target = "stageId", ignore = true)
    @Mapping(target = "matches", ignore = true)
    Stage toEntity(StageRequest request);

}
