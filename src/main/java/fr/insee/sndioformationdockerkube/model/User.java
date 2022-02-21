package fr.insee.sndioformationdockerkube.model;

import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


}
