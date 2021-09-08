package ru.netology.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.netology.model.Authorities;
import ru.netology.model.User;
import ru.netology.repository.UserRepository;
import ru.netology.service.exception.UnauthorizedUser;

@Service
public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getLogin());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}