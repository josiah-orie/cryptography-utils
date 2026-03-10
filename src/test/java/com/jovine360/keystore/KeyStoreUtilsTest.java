package com.jovine360.keystore;

import com.jovine360.symmetric.SymmetricEncryptionUtils;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import java.security.KeyStore;
import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.*;

class KeyStoreUtilsTest {

    @Test
    void createPrivateKeyStore() throws Exception {
        SecretKey key = SymmetricEncryptionUtils.createAESKey();
        String keyHex = HexFormat.of().formatHex(key.getEncoded());

        KeyStore keyStore = KeyStoreUtils.createPrivateKeyStore("keystorePassword", "keyAlias", key, "secretKeyPassword");
        assertNotNull(keyStore);
        System.out.println("Key Store: " + keyStore.size());

        keyStore.load(null, "keystorePassword".toCharArray());
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection("secretKeyPassword".toCharArray());
        KeyStore.SecretKeyEntry entry = (KeyStore.SecretKeyEntry) keyStore.getEntry("keyAlias", entryPassword);
        assertNotNull(entry);
//        SecretKey retrievedKey = entry.getSecretKey();
        String retrievedKeyHex = HexFormat.of().formatHex(entry.getSecretKey().getEncoded());
        assertEquals(keyHex, retrievedKeyHex);
        System.out.println("Retrieved Key: " + retrievedKeyHex);
        System.out.println("Key Hex: " + keyHex);
    }
}