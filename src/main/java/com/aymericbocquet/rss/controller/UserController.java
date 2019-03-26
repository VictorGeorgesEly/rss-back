package com.aymericbocquet.rss.controller;

import com.aymericbocquet.rss.data.dto.LoginFormDTO;
import com.aymericbocquet.rss.data.dto.SuccessfulLoginDTO;
import com.aymericbocquet.rss.data.entity.User;
import com.aymericbocquet.rss.exception.AuthException;
import com.aymericbocquet.rss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

}
