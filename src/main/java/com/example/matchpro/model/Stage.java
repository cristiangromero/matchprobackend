package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stageId;
    @Column(nullable = false, length = 150)
    private String name;
    @OneToMany(mappedBy = "stages",cascade = CascadeType.ALL)
    private List<Match> matches;

    public void setMatches(List<Match> matches) {
        this.matches = matches;
        for(Match m : matches) {
            m.setStages(this);
        }
    }
}
