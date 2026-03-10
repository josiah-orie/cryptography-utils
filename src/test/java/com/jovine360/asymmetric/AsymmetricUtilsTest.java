package com.jovine360.asymmetric;

import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.*;

class AsymmetricUtilsTest {

    @Test
    void generateRSAKeyPair() throws Exception{
        KeyPair keyPair = AsymmetricUtils.generateRSAKeyPair();
        assertNotNull(keyPair, "Key pair should not be null");
        System.out.println("Public Key: " + HexFormat.of().formatHex(keyPair.getPublic().getEncoded()));
        System.out.println("Private Key: " + HexFormat.of().formatHex(keyPair.getPrivate().getEncoded()));
    }

    @Test
    void testRSACryptoRoutine()throws Exception{
        KeyPair keyPair = AsymmetricUtils.generateRSAKeyPair();
        String plainText = "This is a text we will hide in plain text";
        byte[] cipherText = AsymmetricUtils.performRSAEncryption(plainText, keyPair.getPrivate());
        assertNotNull(cipherText, "Cipher text should not be null");
        System.out.println("Cipher Text: " + HexFormat.of().formatHex(cipherText));

        String decryptedText = AsymmetricUtils.performRSADecryption(cipherText, keyPair.getPublic());
        assertEquals(plainText, decryptedText, "Decrypted text should match original text");
        System.out.println("Decrypted Text: " + decryptedText);
    }
}