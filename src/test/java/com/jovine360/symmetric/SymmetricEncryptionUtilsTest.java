package com.jovine360.symmetric;


import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SymmetricEncryptionUtilsTest {

    /**
     * Tests for the SymmetricEncryptionUtils class.
     * <p>
     * Class Description:
     * SymmetricEncryptionUtils is a utility class for symmetric key cryptography.
     * It provides methods for generating AES keys and performing other symmetric encryption-related operations.
     * <p>
     * Method being tested:
     * createAESKey - Generates a 256-bit AES symmetric key using a SecureRandom generator.
     * <p>
     * Exception Testing:
     * The method is expected to throw an Exception if any error arises during the creation of the AES key.
     */

    @Test
    void testCreateAESKeyGeneratesSecretKey() throws Exception {
        // Act
        SecretKey key = SymmetricEncryptionUtils.createAESKey();

        // Assert
        assertNotNull(key, "Generated key should not be null");
        System.out.println("Generated AES Key: " + Arrays.toString(key.getEncoded()));
        System.out.println("Key Encoded: " + HexFormat.of().formatHex(key.getEncoded()));
    }

    @Test
    void testCreateAESKeyUsesCorrectAlgorithm() throws Exception {
        // Act
        SecretKey key = SymmetricEncryptionUtils.createAESKey();

        // Assert
        assertEquals("AES", key.getAlgorithm(), "Generated key algorithm should be AES");
        System.out.println("Key Algorithm: " + key.getAlgorithm());
    }

    @Test
    void testCreateAESKeyKeyLength() throws Exception {
        // Act
        SecretKey key = SymmetricEncryptionUtils.createAESKey();

        // Assert
        assertEquals(256, key.getEncoded().length * 8, "Generated AES key should be 256 bits in length");
        System.out.println("Key Length: " + key.getEncoded().length * 8);
    }

    @Test
    void testPerformEncryption() throws Exception{
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        byte[] iv = SymmetricEncryptionUtils.createInitializationVector();
        String plainText = "Hello, World!";
        byte[] cipherText = SymmetricEncryptionUtils.performEncryption(plainText, key, iv);
        assertNotNull(cipherText, "Encrypted text should not be null");
        System.out.println("Encrypted Text: " + HexFormat.of().formatHex(cipherText));

//        String decryptedText = SymmetricEncryptionUtils.performDecryption(cipherText, key, iv);
//        assertEquals(plainText, decryptedText, "Encrypted and decrypted text should match");
    }

    @Test
    void testPerformDecryption() throws Exception{
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        byte[] iv = SymmetricEncryptionUtils.createInitializationVector();
        String plainText = "Hello, World!";
        byte[] cipherText = SymmetricEncryptionUtils.performEncryption(plainText, key, iv);
        assertNotNull(cipherText, "Encrypted text should not be null");
        System.out.println("Encrypted Text: " + HexFormat.of().formatHex(cipherText));

        String decryptedText = SymmetricEncryptionUtils.performDecryption(cipherText, key, iv);
        assertEquals(plainText, decryptedText, "Encrypted and decrypted text should match");
        System.out.println("Decrypted Text: " + decryptedText);
    }
}