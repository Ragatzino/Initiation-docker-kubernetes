package fr.insee.sndioformationdockerkube.exceptions;

public class UserInexistantException extends Exception {
    public UserInexistantException(String errorMessage) {
        super(errorMessage);
    }
}
