package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stadiums")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stadiumId;
    @Column(nullable = false, length = 150)
    private String name;
    @OneToMany(mappedBy = "stadiums",cascade = CascadeType.ALL)
    private List<Match> matches;

    public void setMatches(List<Match> matches) {
        this.matches = matches;
        for(Match m : matches) {
            m.setStadiums(this);
        }
    }
}
