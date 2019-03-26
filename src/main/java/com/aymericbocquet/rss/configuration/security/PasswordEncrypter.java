package com.aymericbocquet.rss.configuration.security;

import com.aymericbocquet.rss.data.entity.User;
import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class PasswordEncrypter {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordEncrypter.class);

    public static void encryptPassword(User... user) {
        for (User u: user) {
            encryptPassword(u);
        }
    }

    public static void encryptPassword(User user) {
        String password = user.getPassword();
        String encryptedPassword = encryptPassword(password);
        user.setPassword(encryptedPassword);
    }

    public static String encryptPassword(String password) {
        SHA3.DigestSHA3 sha3Password = new SHA3.DigestSHA3(512);
        try {
            sha3Password.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }

        byte[] digestPassword = sha3Password.digest();
        String encryptedPassword = "";
        for (byte d : digestPassword) {
            encryptedPassword += d;
        }

        return encryptedPassword;
    }

}
