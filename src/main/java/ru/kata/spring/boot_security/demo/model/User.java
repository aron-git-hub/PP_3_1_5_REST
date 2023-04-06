package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Shouldn't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$",
            message = "3 to 12 length with no special characters")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Shouldn't be empty")
    @Pattern(regexp = "^[a-zA-ZЁёА-я]{3,12}$",
            message = "3 to 12 length with no numbers and special characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Shouldn't be empty")
    @Pattern(regexp = "^[a-zA-ZЁёА-я]{3,12}$",
            message = "3 to 12 length with no numbers and special characters")
    @Column(name = "second_name")
    private String secondName;

    @Min(value = 1, message = "Should be greater than 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Shouldn't be empty")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String firstName, String secondName, byte age, String password, Set<Role> roles) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}