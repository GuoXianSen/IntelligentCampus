package service;


import dao.IUserDao;
import dao.UserDaoImpl;
import entity.User;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserDao dao = new UserDaoImpl();

    @Override
    public List<User> findUserEasy() {
        return null;
    }

    @Override
    public User findUserByID(int id) {
        return null;
    }

    @Override
    public int findCountUserEasy() {
        return dao.findCountUserEasy();
    }

    @Override
    public List<User> findUserEasyPage(String page, String limit) {

        int pageI = Integer.parseInt(page);
        int limitI =Integer.parseInt(limit);
        int from =(pageI-1)*limitI;
        return dao.findUserEasyPage(from,limitI);
    }

}
