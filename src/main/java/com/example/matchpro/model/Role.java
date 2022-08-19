package com.example.matchpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    @Column(nullable = false, length = 150)
    private String name;
    @OneToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
        for(User u : users) {
            u.setRoles(this);
        }
    }

}
