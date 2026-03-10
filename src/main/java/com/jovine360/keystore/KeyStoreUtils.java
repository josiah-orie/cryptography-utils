package com.jovine360.keystore;

import javax.crypto.SecretKey;
import java.security.KeyStore;

public class KeyStoreUtils {
    private static final String KEYSTORE_TYPE = "JCEKS";

    public static KeyStore createPrivateKeyStore(String keystorePassword, String keyAlias, SecretKey key, String secretKeyPassword) throws Exception{
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        keyStore.load(null, keystorePassword.toCharArray());
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(secretKeyPassword.toCharArray());
        KeyStore.SecretKeyEntry entryKey = new KeyStore.SecretKeyEntry(key);
        keyStore.setEntry(keyAlias, entryKey, entryPassword);
        return keyStore;
    }
}
