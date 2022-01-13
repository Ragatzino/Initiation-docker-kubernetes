package fr.insee.sndioformationdockerkube.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    private static String fonctionDeHashage(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
        return new String(messageDigest.digest());
    }

    public static String hashpassword(String password) throws NoSuchAlgorithmException {
        return fonctionDeHashage(password);
    }


}
