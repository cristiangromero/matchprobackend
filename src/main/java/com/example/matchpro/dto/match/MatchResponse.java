package com.example.matchpro.dto.match;

public record MatchResponse(long id, String date, String stadium, String localTeam, String visitorTeam, String result) {
}
