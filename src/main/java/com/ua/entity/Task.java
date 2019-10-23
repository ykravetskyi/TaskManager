package com.ua.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString(exclude = "users")
@Entity
public class Task {
    //    --------------------------------------------------------
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    List<User> users;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    --------------------------------------------------------
    private String name;
    //    --------------------------------------------------------
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setUser(User user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }
}
