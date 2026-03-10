# cryptography-utils

A small Java utility library that provides reusable helpers for common cryptographic tasks such as:

- AES symmetric encryption
- RSA key pair generation
- Digital signatures
- SHA-256 hashing with salt
- BCrypt password hashing
- Java keystore secret key storage

## Tech stack

- **Java:** 25
- **Build tool:** Maven
- **Test frameworks:** JUnit 4 and JUnit 5
- **Password hashing library:** jBcrypt (`de.svenkubiak:jBcrypt:0.4.1`)

## Project structure
```

text src/main/java/com/jovine360 ├── asymmetric ├── hash ├── keystore ├── signature └── symmetric``` 

## Modules

### `symmetric`
Provides AES-based symmetric encryption utilities.

Main capabilities:
- Generate a 256-bit AES key
- Generate a 16-byte initialization vector (IV)
- Encrypt plaintext using `AES/CBC/PKCS5Padding`
- Decrypt ciphertext back to plaintext

### `asymmetric`
Provides RSA-based asymmetric cryptography helpers.

Main capabilities:
- Generate a 4096-bit RSA key pair
- Perform RSA encryption/decryption routines

### `signature`
Provides digital signature support.

Main capabilities:
- Generate a signature using `SHA256withRSA`
- Verify a signature using the matching public key

### `hash`
Provides hashing and password security helpers.

Main capabilities:
- Generate random salt bytes
- Create a SHA-256 hash from salt + plaintext
- Hash passwords using BCrypt
- Verify plaintext passwords against BCrypt hashes

### `keystore`
Provides Java keystore support for storing secret keys.

Main capabilities:
- Create a `JCEKS` keystore in memory
- Store a `SecretKey` under a chosen alias with password protection

## Requirements

- Java 25
- Maven 3.9+

## Build the project
```

bash mvn clean compile```

## Run tests
```

bash mvn test``` 

## Dependency overview

Key dependencies used by the project:

- `org.junit.jupiter:junit-jupiter:5.12.2`
- `junit:junit:4.13.1`
- `de.svenkubiak:jBcrypt:0.4.1`

## Example usage

### AES encryption and decryption
```

java import com.jovine360.symmetric.SymmetricEncryptionUtils;
import javax.crypto.SecretKey;
public class AesExample { public static void main(String[] args) throws Exception { SecretKey key = SymmetricEncryptionUtils.createAESKey(); byte[] iv = SymmetricEncryptionUtils.createInitializationVector();
String plainText = "Hello, World!";
byte[] cipherText = SymmetricEncryptionUtils.performEncryption(plainText, key, iv);
String decryptedText = SymmetricEncryptionUtils.performDecryption(cipherText, key, iv);

    System.out.println(decryptedText);
}
}```

### SHA-256 hashing with salt
```

java import com.jovine360.hash.HashUtils;
import java.util.HexFormat;
public class HashExample { public static void main(String[] args) throws Exception { byte[] salt = HashUtils.generateRandomSalt(); byte[] hash = HashUtils.createSHA2Hash("my-text", salt);
    System.out.println(HexFormat.of().formatHex(hash));
}
}``` 

### BCrypt password hashing
```

java import com.jovine360.hash.HashUtils;
public class PasswordExample { public static void main(String[] args) { String password = "myPassword"; String hashed = HashUtils.hashPassword(password);
boolean valid = HashUtils.verifyPassword(password, hashed);
System.out.println(valid);
}
}```

### Digital signature generation and verification
```

java import com.jovine360.asymmetric.AsymmetricUtils; import com.jovine360.signature.DigitalSignatureUtils;
import java.security.KeyPair;
public class SignatureExample { public static void main(String[] args) throws Exception { byte[] data = "Important message".getBytes();
    KeyPair keyPair = AsymmetricUtils.generateRSAKeyPair();
    byte[] signature = DigitalSignatureUtils.generateSignature(data, keyPair.getPrivate());

    boolean verified = DigitalSignatureUtils.verifySignature(data, signature, keyPair.getPublic());
    System.out.println(verified);
}
}``` 

### Create a keystore and store a secret key
```

java import com.jovine360.keystore.KeyStoreUtils; import com.jovine360.symmetric.SymmetricEncryptionUtils;
import javax.crypto.SecretKey; import java.security.KeyStore;
public class KeyStoreExample { public static void main(String[] args) throws Exception { SecretKey key = SymmetricEncryptionUtils.createAESKey();
KeyStore keyStore = KeyStoreUtils.createPrivateKeyStore(
"changeit",
"my-secret-key",
key,
"entry-password"
);

    System.out.println("Entries: " + keyStore.size());
}
}```

## Notes

- This project is primarily a utility/demo-style library for learning and reuse.
- For production-grade cryptography, review:
    - algorithm choices
    - key handling
    - encoding/charset handling
    - error handling
    - secure storage practices
    - modern cipher modes and padding strategies

## License

Add your preferred license here.
```

Optional improvement
If you want, I can also prepare a more polished README with:
badges
a short security disclaimer
a “Getting Started” section
API summary tables
a “Future improvements” section
If you want that version, I can draft it next.

## Me
create the file

## AI Assistant

I can’t directly write files in this session, but here is the exact README.md content to add at the project root.``` md
# cryptography-utils

A small Java utility library that provides reusable helpers for common cryptographic tasks such as:

- AES symmetric encryption
- RSA key pair generation
- Digital signatures
- SHA-256 hashing with salt
- BCrypt password hashing
- Java keystore secret key storage

## Tech stack

- **Java:** 25
- **Build tool:** Maven
- **Test frameworks:** JUnit 4 and JUnit 5
- **Password hashing library:** jBcrypt (`de.svenkubiak:jBcrypt:0.4.1`)

## Project structure
```

text src/main/java/com/jovine360 ├── asymmetric ├── hash ├── keystore ├── signature └── symmetric```

## Modules

### `symmetric`
Provides AES-based symmetric encryption utilities.

Main capabilities:
- Generate a 256-bit AES key
- Generate a 16-byte initialization vector (IV)
- Encrypt plaintext using `AES/CBC/PKCS5Padding`
- Decrypt ciphertext back to plaintext

### `asymmetric`
Provides RSA-based asymmetric cryptography helpers.

Main capabilities:
- Generate a 4096-bit RSA key pair
- Perform RSA encryption/decryption routines

### `signature`
Provides digital signature support.

Main capabilities:
- Generate a signature using `SHA256withRSA`
- Verify a signature using the matching public key

### `hash`
Provides hashing and password security helpers.

Main capabilities:
- Generate random salt bytes
- Create a SHA-256 hash from salt + plaintext
- Hash passwords using BCrypt
- Verify plaintext passwords against BCrypt hashes

### `keystore`
Provides Java keystore support for storing secret keys.

Main capabilities:
- Create a `JCEKS` keystore in memory
- Store a `SecretKey` under a chosen alias with password protection

## Requirements

- Java 25
- Maven 3.9+

## Build the project
```

bash mvn clean compile``` 

## Run tests
```

bash mvn test```

## Dependency overview

Key dependencies used by the project:

- `org.junit.jupiter:junit-jupiter:5.12.2`
- `junit:junit:4.13.1`
- `de.svenkubiak:jBcrypt:0.4.1`

## Example usage

### AES encryption and decryption
```

java import com.jovine360.symmetric.SymmetricEncryptionUtils;
import javax.crypto.SecretKey;
public class AesExample { public static void main(String[] args) throws Exception { SecretKey key = SymmetricEncryptionUtils.createAESKey(); byte[] iv = SymmetricEncryptionUtils.createInitializationVector();
    String plainText = "Hello, World!";
    byte[] cipherText = SymmetricEncryptionUtils.performEncryption(plainText, key, iv);
    String decryptedText = SymmetricEncryptionUtils.performDecryption(cipherText, key, iv);

    System.out.println(decryptedText);
}
}``` 

### SHA-256 hashing with salt
```

java import com.jovine360.hash.HashUtils;
import java.util.HexFormat;
public class HashExample { public static void main(String[] args) throws Exception { byte[] salt = HashUtils.generateRandomSalt(); byte[] hash = HashUtils.createSHA2Hash("my-text", salt);
System.out.println(HexFormat.of().formatHex(hash));
}
}```

### BCrypt password hashing
```

java import com.jovine360.hash.HashUtils;
public class PasswordExample { public static void main(String[] args) { String password = "myPassword"; String hashed = HashUtils.hashPassword(password);
    boolean valid = HashUtils.verifyPassword(password, hashed);
    System.out.println(valid);
}
}``` 

### Digital signature generation and verification
```

java import com.jovine360.asymmetric.AsymmetricUtils; import com.jovine360.signature.DigitalSignatureUtils;
import java.security.KeyPair;
public class SignatureExample { public static void main(String[] args) throws Exception { byte[] data = "Important message".getBytes();
KeyPair keyPair = AsymmetricUtils.generateRSAKeyPair();
byte[] signature = DigitalSignatureUtils.generateSignature(data, keyPair.getPrivate());

    boolean verified = DigitalSignatureUtils.verifySignature(data, signature, keyPair.getPublic());
    System.out.println(verified);
}
}```

### Create a keystore and store a secret key
```

java import com.jovine360.keystore.KeyStoreUtils; import com.jovine360.symmetric.SymmetricEncryptionUtils;
import javax.crypto.SecretKey; import java.security.KeyStore;
public class KeyStoreExample { public static void main(String[] args) throws Exception { SecretKey key = SymmetricEncryptionUtils.createAESKey();
    KeyStore keyStore = KeyStoreUtils.createPrivateKeyStore(
            "changeit",
            "my-secret-key",
            key,
            "entry-password"
    );

    System.out.println("Entries: " + keyStore.size());
}
}``` 

## Notes

- This project is primarily a utility/demo-style library for learning and reuse.
- For production-grade cryptography, review:
  - algorithm choices
  - key handling
  - encoding and charset handling
  - error handling
  - secure storage practices
  - modern cipher modes and padding strategies

## License

Add your preferred license here.
```

If you want, I can also tailor this into a shorter README or a more professional GitHub-style version with badges and setup notes.

## Me
generate the draft

## AI Assistant

Sure — here’s a cleaner README.md draft you can use as-is.``` md
# cryptography-utils

A lightweight Java utility library for common cryptographic operations, including:

- AES symmetric encryption
- RSA key pair generation
- Digital signatures
- SHA-256 hashing with salt
- BCrypt password hashing
- Secret key storage with Java KeyStore

## Overview

This project groups practical cryptography helpers into focused utility classes to make common security-related tasks easier to implement and test in Java applications.

It is structured as a Maven project and targets **Java 25**.

## Features

### Symmetric encryption
- Generate 256-bit AES keys
- Generate initialization vectors (IVs)
- Encrypt plaintext using `AES/CBC/PKCS5Padding`
- Decrypt ciphertext back to plaintext

### Asymmetric cryptography
- Generate 4096-bit RSA key pairs
- Perform RSA encryption/decryption routines

### Digital signatures
- Sign data using `SHA256withRSA`
- Verify signatures using a public key

### Hashing
- Generate random salt values
- Create SHA-256 hashes from plaintext + salt
- Hash passwords using BCrypt
- Verify passwords against BCrypt hashes

### KeyStore support
- Create an in-memory `JCEKS` keystore
- Store secret keys under a protected alias

## Tech Stack

- **Java:** 25
- **Build tool:** Maven
- **Testing:** JUnit 4 and JUnit 5
- **Password hashing library:** jBcrypt

## Project Layout
```

text src/ ├── main/ │ ├── java/com/jovine360/ │ │ ├── asymmetric/ │ │ ├── hash/ │ │ ├── keystore/ │ │ ├── signature/ │ │ └── symmetric/ │ └── resources/ └── test/ └── java/com/jovine360/``` 

## Requirements

- Java 25
- Maven 3.9 or later

## Build
```

bash mvn clean compile```

## Test
```

bash mvn test``` 

## Dependencies

- `org.junit.jupiter:junit-jupiter:5.12.2`
- `junit:junit:4.13.1`
- `de.svenkubiak:jBcrypt:0.4.1`

## Usage Examples

### AES encryption and decryption
```

java import com.jovine360.symmetric.SymmetricEncryptionUtils; import javax.crypto.SecretKey;
public class AesExample { public static void main(String[] args) throws Exception { SecretKey key = SymmetricEncryptionUtils.createAESKey(); byte[] iv = SymmetricEncryptionUtils.createInitializationVector();
String plainText = "Hello, World!";
byte[] cipherText = SymmetricEncryptionUtils.performEncryption(plainText, key, iv);
String decryptedText = SymmetricEncryptionUtils.performDecryption(cipherText, key, iv);

    System.out.println(decryptedText);
}
}```

### SHA-256 hashing with salt
```

java import com.jovine360.hash.HashUtils; import java.util.HexFormat;
public class HashExample { public static void main(String[] args) throws Exception { byte[] salt = HashUtils.generateRandomSalt(); byte[] hash = HashUtils.createSHA2Hash("my-text", salt);
    System.out.println(HexFormat.of().formatHex(hash));
}
}``` 

### BCrypt password hashing
```

java import com.jovine360.hash.HashUtils;
public class PasswordExample { public static void main(String[] args) { String password = "myPassword"; String hashedPassword = HashUtils.hashPassword(password);
boolean valid = HashUtils.verifyPassword(password, hashedPassword);
System.out.println(valid);
}
}```

### Digital signatures
```

java import com.jovine360.asymmetric.AsymmetricUtils; import com.jovine360.signature.DigitalSignatureUtils;
import java.security.KeyPair;
public class SignatureExample { public static void main(String[] args) throws Exception { byte[] data = "Important message".getBytes();
    KeyPair keyPair = AsymmetricUtils.generateRSAKeyPair();
    byte[] signature = DigitalSignatureUtils.generateSignature(data, keyPair.getPrivate());

    boolean verified = DigitalSignatureUtils.verifySignature(data, signature, keyPair.getPublic());
    System.out.println("Verified: " + verified);
}
}``` 

### KeyStore usage
```

java import com.jovine360.keystore.KeyStoreUtils; import com.jovine360.symmetric.SymmetricEncryptionUtils;
import javax.crypto.SecretKey; import java.security.KeyStore;
public class KeyStoreExample { public static void main(String[] args) throws Exception { SecretKey key = SymmetricEncryptionUtils.createAESKey();
KeyStore keyStore = KeyStoreUtils.createPrivateKeyStore(
"changeit",
"my-secret-key",
key,
"entry-password"
);

    System.out.println("KeyStore entries: " + keyStore.size());
}
}```

## Notes

- This library is useful for demos, experiments, and reusable crypto helpers.
- Before using cryptography code in production, review:
    - algorithm suitability
    - secure key management
    - storage and rotation practices
    - encoding/charset handling
    - modern cipher modes and security best practices

## Future Improvements

Potential enhancements for this project:

- Add support for authenticated encryption such as AES-GCM
- Add utility methods for Base64 encoding/decoding
- Add file-based keystore persistence helpers
- Improve exception handling with custom domain exceptions
- Add API documentation and examples for each utility class

## License

