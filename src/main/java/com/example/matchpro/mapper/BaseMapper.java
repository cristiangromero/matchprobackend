package com.example.matchpro.mapper;

import java.util.List;

public interface BaseMapper<Entity, Response> {
    List<Response> toResponses(List<Entity> entities);
}
