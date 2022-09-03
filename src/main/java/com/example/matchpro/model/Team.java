package com.example.matchpro.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;
    @Column(nullable = false, length = 150)
    private String name;
    private String flag;
    @OneToMany(mappedBy = "locals",cascade = CascadeType.ALL)
    private List<Match> localMatches;
    @OneToMany(mappedBy = "visitors",cascade = CascadeType.ALL)
    private List<Match> visitorMatches;

    public Team(Long teamId, String name, String flag) {
        this.teamId = teamId;
        this.name = name;
        this.flag = flag;
    }

    public void setLocalMatches(List<Match> matches) {
        this.localMatches = matches;
        for(Match m : matches) {
            m.setLocals(this);
        }
    }
    public void setVisitorMatches(List<Match> matches){
        this.visitorMatches = matches;
        for(Match m : matches) {
            m.setVisitors(this);
        }
    }

}
