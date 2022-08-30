package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "matches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchId;
    private java.sql.Date matchDate;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "stadiumId", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Stadium stadiums;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "stageId", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Stage stages;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "resultId", nullable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Result results;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "localTeam", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Team locals;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "visitorTeam", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Team visitors;
}
