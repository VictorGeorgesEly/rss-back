package com.aymericbocquet.rss.controller;

import com.aymericbocquet.rss.data.dto.LoginFormDTO;
import com.aymericbocquet.rss.data.dto.SuccessfulLoginDTO;
import com.aymericbocquet.rss.data.entity.User;
import com.aymericbocquet.rss.exception.AuthException;
import com.aymericbocquet.rss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public SuccessfulLoginDTO login(@RequestBody LoginFormDTO form, HttpServletResponse res) {
        User user = userService.authenticate(form.getLogin(), form.getPassword());

        if (user == null) {
            res.setStatus(400);
            throw new AuthException("User not found");
        }

        return new SuccessfulLoginDTO(user);
    }

    @GetMapping
    public List<User> getAllRss() {
        return userService.getAllUser();
    }

}
