package com.jovine360.signature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureUtils {
    private static String SIGNATURE_ALGORITHM = "SHA256withRSA";

    public static byte[] generateSignature(byte[] input, PrivateKey privateKey) throws Exception{
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(input);
        return signature.sign();
    }

    public static boolean verifySignature(byte[] input, byte[] signature, PublicKey publicKey) throws Exception{
        Signature signature1 = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature1.initVerify(publicKey);
        signature1.update(input);
        return signature1.verify(signature);
    }
}
