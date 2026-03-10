package com.jovine360.signature;

import com.jovine360.asymmetric.AsymmetricUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.util.HexFormat;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureUtilsTest {

    @Test
    void generateAndVerifySignature() throws Exception {
        URL uri = this.getClass().getResource("/demo.txt");
        Path path = Paths.get(uri.toURI());
        byte[] input = Files.readAllBytes(path);

        KeyPair keyPair = AsymmetricUtils.generateRSAKeyPair();
        byte[] signature = DigitalSignatureUtils.generateSignature(input, keyPair.getPrivate());
        assertNotNull(signature);
        System.out.println("Signature Length: " + signature.length);
        System.out.println("Signature: " + HexFormat.of().formatHex(signature));

        assertTrue(DigitalSignatureUtils.verifySignature(input, signature, keyPair.getPublic()));
    }

}