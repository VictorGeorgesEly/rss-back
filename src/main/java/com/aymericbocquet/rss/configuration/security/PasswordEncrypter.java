package com.aymericbocquet.rss.configuration.security;

import com.aymericbocquet.rss.data.entity.User;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class PasswordEncrypter {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordEncrypter.class);

    public static void encryptPassword(User... user) {
        for (User u : user) {
            encryptPassword(u);
        }
    }

    public static void encryptPassword(User user) {
        String password = user.getPassword();
        String encryptedPassword = encryptPassword(password);
        user.setPassword(encryptedPassword);
    }

    public static String encryptPassword(String password) {
        SHA512Digest sha512Digest = new SHA512Digest();
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        sha512Digest.update(passwordBytes, 0, passwordBytes.length);

        byte[] digestPassword = new byte[sha512Digest.getDigestSize()];
        sha512Digest.doFinal(digestPassword, 0);
        String encryptedPassword = "";
        for (byte d : digestPassword) {
            encryptedPassword += d;
        }
        return encryptedPassword;
    }

}
