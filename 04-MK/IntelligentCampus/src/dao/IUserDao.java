package dao;

import entity.User;

import java.util.List;

public interface IUserDao {
    //添加用户
    User Insert(User user);
    int PsdUpdatewx(User user);
    //编辑信息小程序
    int UserUpdatewx(User user);

    //通过ID查询用户
    User GetUserByID(int id);

    //通过用户名查询用户
    User getUserByName(String name);

    //获取所有用户
    List<User> GetAllUser();

    //账号密码登录校验
    User GetUserByNamePwd(String username,String password);

    //删除用户
    int UserDelete(int userid);

    int findCountUserEasy();

    //更新用户
    int UserUpdate(User user);

    List<User> findUserEasyPage(int from, int limitI);

}
