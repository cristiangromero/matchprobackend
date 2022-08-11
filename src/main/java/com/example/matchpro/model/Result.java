package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "results")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resultId;
    @Column(nullable = false, length = 150)
    private String name;
    @OneToMany(mappedBy = "results",cascade = CascadeType.ALL)
    private List<Match> matches;
    @OneToMany(mappedBy = "results",cascade = CascadeType.ALL)
    private List<Bet> bets;

    public void setMatches(List<Match> matches) {
        this.matches = matches;
        for(Match m : matches) {
            m.setResults(this);
        }
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
        for(Bet b : bets) {
            b.setResults(this);
        }
    }
}
