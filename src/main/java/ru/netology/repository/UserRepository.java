package ru.netology.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ru.netology.model.Authorities;
import ru.netology.model.User;

@Repository
public class UserRepository {

    private Map<String,List<Authorities>> authorities = new HashMap<>(){{
        put("login:password", new ArrayList<Authorities>(){{
            add(Authorities.READ);
        }});
        put("editor:edit", new ArrayList<Authorities>(){{
            add(Authorities.READ);
            add(Authorities.WRITE);
        }});
        put("admin:12345", new ArrayList<Authorities>(){{
            add(Authorities.READ);
            add(Authorities.WRITE);
            add(Authorities.DELETE);
        }});
    }};

    public List<Authorities> getUserAuthorities(User user) {
        return authorities.get(user.getLogin() + ":" + user.getPassword());
    }
}