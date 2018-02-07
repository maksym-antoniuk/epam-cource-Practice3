package ua.nure.antoniuk.Practice3;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Max on 14.11.2017.
 */
public class Part4 {

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~Part4~~~~~~~~~~~~");
        try {
            System.out.println(hash("password", "SHA-256"));
            System.out.println(hash("passwort", "SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] bytes = digest.digest();
        return DatatypeConverter.printHexBinary(bytes);
    }
}
