package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = true)
    private int score;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn (name = "roleId", nullable = true, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Role roles;
    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<Bet> bets;

    public void setBets(List<Bet> bets) {
        this.bets = bets;
        for(Bet b : bets) {
            b.setUsers(this);
        }
    }

}
