package com.example.springsecuritylogin.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public @Data @AllArgsConstructor @NoArgsConstructor class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    @Pattern(regexp = "[a-zA-Z]+[ a-zA-Z]+",message = "Enter a valid Username")
    @Column(name = "username")
    private String username;

    @Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$",message="Enter a Valid Email Address")
    @Column(name = "email",unique = true)
    //@Unique(message="Email already registered!!!")
    private String email;


    @Pattern(regexp="[0-9]{10}",message="Enter a valid Mobile Number of 10 digits")
    @Column(name="mobile")
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Item> items;

    @Column(name = "password")
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;


    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public User(int userId, String userName, String userEmail, String userMobile) {
        this.userId = userId;
        this.username = userName;
        this.email = userEmail;
        this.mobile = userMobile;
    }

    public void add(Item item){
        if(items==null){
            items=new ArrayList<>();
        }
        items.add(item);
    }

}
