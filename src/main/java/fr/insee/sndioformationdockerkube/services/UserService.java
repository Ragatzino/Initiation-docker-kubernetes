package fr.insee.sndioformationdockerkube.services;

import fr.insee.sndioformationdockerkube.dao.UserRepository;
import fr.insee.sndioformationdockerkube.dto.UserDto;
import fr.insee.sndioformationdockerkube.exceptions.UserInexistantException;
import fr.insee.sndioformationdockerkube.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllUsers(){
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(UserDto::dtoFromEntity)
                .collect(Collectors.toList());
    }

    public UserDto addUser(UserDto userDto) throws NoSuchAlgorithmException,RuntimeException {
        User userFromDto = userDto.createFromDto();
        userRepository.save(userFromDto);
        return userDto;
    }

    public UserDto deleteUserByNom(String username) throws UserInexistantException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UserInexistantException("L'utilisateur n'existe pas");
        }
        userRepository.deleteByUsername(username);
        return UserDto.dtoFromEntity(user);
    }


}
