package com.ua.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    //    --------------------------------------------------------
    @Column(unique = true)
    private String username;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //    --------------------------------------------------------
    @Column(unique = true)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    --------------------------------------------------------
    private String password;

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //    --------------------------------------------------------
    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //    --------------------------------------------------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    //    --------------------------------------------------------
    private boolean isActivated;

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    @Override
    public boolean isEnabled() {
        return isActivated();
    }

    //    --------------------------------------------------------
    private boolean isAccountNonExpired;

    //account is valid
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    //    --------------------------------------------------------
    private boolean isAccountNonLocked;

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    //    --------------------------------------------------------
    private boolean isCredentialsNonExpired;

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    //    --------------------------------------------------------
    private String activationCode;

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    //    --------------------------------------------------------
    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH,
            mappedBy = "users"
    )
    List<Task> tasks;

}
