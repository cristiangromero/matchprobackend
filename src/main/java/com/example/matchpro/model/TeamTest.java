package com.example.matchpro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamTest {
    private Long id;
    private String name;
    private String code;
    private String country;
    private int founded;
    private Boolean national;
    private String logo;
}