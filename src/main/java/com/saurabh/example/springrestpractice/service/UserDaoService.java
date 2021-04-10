package com.saurabh.example.springrestpractice.service;

import com.saurabh.example.springrestpractice.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class UserDaoService {
    private static List<User> list = new ArrayList<>();
    private static Integer userCount = 5;

    static {
        list.add(new User(1, "Saurabh", LocalDate.of(1986, Month.SEPTEMBER, 19)));
        list.add(new User(2, "Bhavana", LocalDate.of(1990, Month.DECEMBER, 17)));
        list.add(new User(3, "Komal", LocalDate.of(1985, Month.MAY, 5)));
        list.add(new User(4, "Pradnya", LocalDate.of(1985, Month.MARCH, 29)));
        list.add(new User(5, "Jackqueline", LocalDate.of(1990, Month.JULY, 12)));
    }

    public List<User> findAll() {
        return list;
    }

    public User adduser(User user) {
        if (Objects.isNull(user.getUserId()))
            user.setUserId(++userCount);
        list.add(user);
        return user;
    }

    public User findOne(int Id) {
        /*return list.stream()
                .filter(
                        user->user
                                .getUserId()
                                .equals(Id))
                .findFirst()
                .get();*/
        for (User user : list)
            if (user.getUserId().equals(Id))
                return user;

        return null;
    }

    public User deleteById(int Id) {
        Iterator<User> userIterator = list.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getUserId().equals(Id)) {
                userIterator.remove();
                return user;
            }
        }
        return null;
    }
}
