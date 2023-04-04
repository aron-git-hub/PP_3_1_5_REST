package ru.kata.spring.boot_security.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Shouldn't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{3,12}$",
            message = "3 to 12 length with no special characters")
    @Column(name = "user_name")
    private String userName;

    @NotEmpty(message = "Shouldn't be empty")
    @Pattern(regexp = "^[a-zA-ZЁёА-я0-9]{3,12}$",
            message = "3 to 12 length")
    @Column(name = "password")
    private String password;

    @Min(value = 1, message = "Should be greater than 0")
    @Column(name = "age")
    private byte age;

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

    public User() {
    }

    public User(long id, String userName, String password, byte age, String firstName, String secondName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
