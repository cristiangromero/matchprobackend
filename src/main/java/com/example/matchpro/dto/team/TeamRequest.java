package com.example.matchpro.dto.team;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TeamRequest {
    private long id;
    private String name, flag;
}
