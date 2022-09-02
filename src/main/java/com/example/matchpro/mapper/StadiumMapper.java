package com.example.matchpro.mapper;

import com.example.matchpro.dto.stadium.StadiumRequest;
import com.example.matchpro.dto.stadium.StadiumResponse;
import com.example.matchpro.model.Stadium;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StadiumMapper extends BaseMapper<Stadium, StadiumResponse> {

    @Mapping(target = "id", source = "stadiumId")
    StadiumResponse toResponse(Stadium entity);

    @Mapping(target = "stadiumId", ignore = true)
    @Mapping(target = "matches", ignore = true)
    Stadium toEntity(StadiumRequest request);

    @Mapping(target = "stadiumId", source = "id")
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "matches", ignore = true)
    Stadium map(Long id);

}
