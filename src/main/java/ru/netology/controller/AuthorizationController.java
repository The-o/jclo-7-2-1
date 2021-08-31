package ru.netology.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.model.Authorities;
import ru.netology.service.AuthorizationService;
import ru.netology.service.exception.InvalidCredentials;
import ru.netology.service.exception.UnauthorizedUser;

@RestController
public class AuthorizationController {
    private AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials(InvalidCredentials e) {
        return e.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getLocalizedMessage());
        return e.getLocalizedMessage();
    }
}