package com.jovine360.hash;

import org.mindrot.jbcrypt.BCrypt;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class HashUtils {
    private static final String SHA_256 = "SHA-256";

    public static byte[] generateRandomSalt(){
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] createSHA2Hash(String plainText, byte[] salt) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(salt);
        outputStream.write(plainText.getBytes());
        byte[] valueOf = outputStream.toByteArray();

        MessageDigest digest = MessageDigest.getInstance(SHA_256);
        return digest.digest(valueOf);
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
