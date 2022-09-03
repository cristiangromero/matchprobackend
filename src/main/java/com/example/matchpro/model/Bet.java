package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "bets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long betId;
    @Column(nullable = false)
    private Date betDate;
    @Column(nullable = true)
    private int userPoints;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "resultId", nullable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Result results;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "matchId", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Match matches;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "userId", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User users;
}
