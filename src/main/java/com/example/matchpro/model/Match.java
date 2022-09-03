package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "matches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchId;
    private Date matchDate;
    private String status;
    private String stadium;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "stageId", nullable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Stage stages;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "resultId", nullable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Result results;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "localTeam", nullable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Team locals;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "visitorTeam", nullable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Team visitors;

    public Match(Long matchId, Date matchDate, String status) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.status = status;
    }
}
