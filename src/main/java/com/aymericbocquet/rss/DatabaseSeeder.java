package com.aymericbocquet.rss;

import com.aymericbocquet.rss.configuration.security.PasswordEncrypter;
import com.aymericbocquet.rss.constant.RolesNames;
import com.aymericbocquet.rss.data.dao.RoleRepository;
import com.aymericbocquet.rss.data.dao.UserRepository;
import com.aymericbocquet.rss.data.entity.Role;
import com.aymericbocquet.rss.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DatabaseSeeder {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public void seedDatabase() {
        if (isDatabaseSeeded()) {
            System.out.println("Database is already seeded. Exiting seeder.");
            return;
        }
        runSeedDatabase();
        System.out.println("Database successfully initialized ! Exiting seeder \uD83D\uDC4D");
    }

    private boolean isDatabaseSeeded() {
        // if it's found, the database is already seeded
        return userRepository.existsById(1L);
    }

    private void runSeedDatabase() {
        List<Role> listRole = new ArrayList<>();
        Role roleAdmin = new Role(RolesNames.ADMIN);
        listRole.add(roleAdmin);
        Role roleUser = new Role(RolesNames.USER);
        listRole.add(roleUser);

        List<Role> listRoleAdmin = new ArrayList<>(Collections.singleton(roleAdmin));
        List<Role> listRoleUser = new ArrayList<>(Collections.singleton(roleUser));

        List<User> listUser = new ArrayList<>();

        User user = new User();
        user.setUsername("Admin");
        user.setFirstName("Victor");
        user.setLastName("ELY");
        user.setMail("victor.georges.ely@gmail.com");
        user.setPassword("MuseU2&Coldplay");
        user.setRoles(listRoleAdmin);

        PasswordEncrypter.encryptPassword(user);

        listUser.add(user);

        user = new User();
        user.setUsername("User");
        user.setFirstName("Nicolas");
        user.setLastName("De CHEVIGNE");
        user.setMail("victor.georges.ely@gmail.com");
        user.setPassword("MuseU2&Coldplay");
        user.setRoles(listRoleUser);

        PasswordEncrypter.encryptPassword(user);

        listUser.add(user);

        roleRepository.saveAll(listRole);
        userRepository.saveAll(listUser);


    }

}
