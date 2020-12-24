package service;


import entity.User;

import java.util.List;

public interface IUserService {
    List<User> findUserEasy();

    User findUserByID(int id);

    int     findCountUserEasy();

    List<User> findUserEasyPage(String page, String limit);
}
