package com.aymericbocquet.rss.service;

import com.aymericbocquet.rss.configuration.security.PasswordEncrypter;
import com.aymericbocquet.rss.data.dao.UserRepository;
import com.aymericbocquet.rss.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String login, String password) {
        String encryptedPassword = PasswordEncrypter.encryptPassword(password);
        User user = userRepository.findByUsernameAndPassword(login, encryptedPassword);

        if (user == null) {
            return null;
        }

        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        user.setToken(token);
        userRepository.save(user);

        return user;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //public User createUser(String )

}
