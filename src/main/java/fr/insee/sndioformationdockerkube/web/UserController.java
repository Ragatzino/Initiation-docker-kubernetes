package fr.insee.sndioformationdockerkube.web;

import fr.insee.sndioformationdockerkube.dto.UserDto;
import fr.insee.sndioformationdockerkube.exceptions.UserInexistantException;
import fr.insee.sndioformationdockerkube.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody UserDto userDto) throws NoSuchAlgorithmException {
        try {
            UserDto user = userService.addUser(userDto);
            return user;
        }catch (RuntimeException runtimeException){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,runtimeException.getMessage(), runtimeException);
        }
    }

    @GetMapping(path = "users")
    public List<UserDto> findAllUsers() {
        List<UserDto> users = userService.findAllUsers();
        return users;
    }

    @DeleteMapping(path = "user/{name}")
    public UserDto deleteUserByName(@RequestParam("name") String name) {
        try {
            UserDto deletedUser = userService.deleteUserByNom(name);
            return deletedUser;
        } catch (UserInexistantException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
