package com.example.matchpro.mapper;

import com.example.matchpro.dto.result.ResultRequest;
import com.example.matchpro.dto.result.ResultResponse;
import com.example.matchpro.model.Result;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResultMapper extends BaseMapper<Result, ResultResponse> {

    @Mapping(target = "id", source = "resultId")
    ResultResponse toResponse(Result entity);

    @Mapping(target = "resultId", ignore = true)
    @Mapping(target = "matches", ignore = true)
    @Mapping(target = "bets", ignore = true)
    Result toEntity(ResultRequest request);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "matches", ignore = true)
    @Mapping(target = "bets", ignore = true)
    @Mapping(target = "resultId", source = "id")
    Result map(Long id);

}
