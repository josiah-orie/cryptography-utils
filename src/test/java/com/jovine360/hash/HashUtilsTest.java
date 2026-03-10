package com.jovine360.hash;

import org.junit.jupiter.api.Test;

import java.util.HexFormat;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilsTest {

    @Test
    void generateRandomSalt() {
        byte[] salt = HashUtils.generateRandomSalt();
        assertNotNull(salt);
        System.out.println("Generated Salt: " + salt.length);
    }

    @Test
    void createSHA2Hash() throws Exception {
        byte[] salt = HashUtils.generateRandomSalt();
        String plainText = UUID.randomUUID().toString();
        byte[] hash = HashUtils.createSHA2Hash(plainText, salt);
        assertNotNull(hash);
        System.out.println("SHA2 Hash: " + hash.length);
        System.out.println("Hash Text: " + HexFormat.of().formatHex(hash));

        byte[] hash2 = HashUtils.createSHA2Hash(plainText, salt);
        assertArrayEquals(hash, hash2);
        System.out.println("Hash Text2: " + HexFormat.of().formatHex(hash2));

    }

    @Test
    void hashPassword() {
        String password = "Josiah'sPassword";
        String hashedPassword = HashUtils.hashPassword(password);
        assertNotNull(hashedPassword);
        System.out.println("Hashed Password: " + hashedPassword);
    }
    @Test
    void verifyPassword() {
        String password = "Josiah'sPassword";
        String hashedPassword = HashUtils.hashPassword(password);
        assertTrue(HashUtils.verifyPassword(password, hashedPassword));
        System.out.println("Password Verified: " + HashUtils.verifyPassword(password, hashedPassword));
    }
}