package fr.insee.sndioformationdockerkube.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.insee.sndioformationdockerkube.model.User;
import fr.insee.sndioformationdockerkube.utils.PasswordUtils;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public class UserDto implements Serializable {
    @JsonProperty(value = "name")
    final String nom;
    @JsonProperty(value = "password")
    final String password;

    public UserDto(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }
    public User createFromDto() throws NoSuchAlgorithmException {
        String mdp = PasswordUtils.hashpassword(password);
        return new User(nom,mdp);
    }
    public static UserDto dtoFromEntity(User user){
        return new UserDto(user.getUsername(), user.getPassword());
    }

}
