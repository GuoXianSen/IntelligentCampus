package dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.MyDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao{

    /**
     * 插入用户数据
     * @return
     */
    @Override
    public User Insert(User user) {
        User  list=new User();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "insert into user(username,password,sex,age,phonenumber,userimg,email,college,major) value(?,?,?,?,?,?,?,?,?) ";
        Object[] param = {user.getUsername(),user.getPassword(),user.getSex(),user.getAge(),user.getPhonenumber(),user.getUserimg(),
        user.getEmail(),user.getCollege(),user.getMajor()};
        try {
            list = qr.insert(sql,new BeanHandler<>(User.class),param);
            System.out.println("===========================>");
            System.out.println(list);
            System.out.println("===========================>");
        }  catch ( SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //编辑信息小程序端
    @Override
    public int UserUpdatewx(User user) {
        int bool = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "update user set sex=?,age=?,phonenumber=?,userimg=?,email=?,college=?,major=? where id=?";
        Object[] param = {user.getSex(),user.getAge(),user.getPhonenumber(),user.getUserimg(),user.getEmail(),user.getCollege(),user.getMajor(),user.getId()};
        try {
            bool= qr.update(sql,param);
            System.out.println("****************************");;
            System.out.println(bool);
            System.out.println("****************************");;
        }  catch ( SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return bool;
    }
    //修改密码根据id
    @Override
    public int PsdUpdatewx(User user) {
        int bool = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "update user set password=? where id=?";
        Object[] param = {user.getPassword(),user.getId()};
        try {
            bool= qr.update(sql,param);
            System.out.println("****************************");;
            System.out.println(bool);
            System.out.println("****************************");;
        }  catch ( SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return bool;
    }


    //根据id获取用户
    @Override
    public User GetUserByID(int id) {

        return null;
    }

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public User getUserByName(String username) {
        User  list=new User();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from user where username=? ";
        Object[] param = {username};
        try {
           list = qr.query(sql,new BeanHandler<>(User.class),param);
          System.out.println(list);

        }  catch ( SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //取得所有用户
    @Override
    public List<User> GetAllUser() {
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from user  ";
        Object[] param = {};
        List<User> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<User>(User.class), param);
            System.out.println("=====================>");
            System.out.println(list);
            System.out.println("=====================>");
        } catch (SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return list;
    }

    //根据用户名密码获取用户
    @Override
    public User GetUserByNamePwd(String username, String password) {
        User  list=new User();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from user where username=? and password = ?";
        Object[] param = {username,password};
        try {
            list = qr.query(sql,new BeanHandler<>(User.class),param);
            System.out.println("=====================>");
            System.out.println(list);
            System.out.println("=====================>");

        }  catch ( SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return list;
    }

    //根据id删除一条记录
    @Override
    public int UserDelete(int id) {

        int bool = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "DELETE FROM user WHERE id=?;";
        Object[] param = {id};
        try {
            bool = qr.update(sql,param);
            System.out.println("=====================>");
            System.out.println(bool);
            System.out.println("=====================>");
        }  catch ( SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return bool;
    }


    /**
     * 更新数据
     * @param user
     * @return
     */
    @Override
    public int UserUpdate(User user) {
        int bool = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "update user set username=?,password=?,sex=?,age=?,phonenumber=?,userimg=?,email=?,college=?,major=? where id=?";
        Object[] param = {user.getUsername(),user.getPassword(),user.getSex(),user.getAge(),user.getPhonenumber(),user.getUserimg(),user.getEmail(),user.getCollege(),user.getMajor(),user.getId()};
        try {
           bool= qr.update(sql,param);
            System.out.println("****************************");;
            System.out.println(bool);
            System.out.println("****************************");;
        }  catch ( SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return bool;
    }

    @Override
    public int findCountUserEasy() {
        int count = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select count(0) from user";
        Object[] param = {};
        try {

            count = Integer.parseInt(qr.query(sql,new ScalarHandler<User>(),param)+"");

            System.out.println("=====================>");
            System.out.println(count);
            System.out.println("=====================>");

        }  catch ( SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return count;
    }

    @Override
    public List<User> findUserEasyPage(int from, int limitI) {
        List<User> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());


        String sql = "select * from user limit ?,?";
        Object[] param = {from, limitI};
        try {
            list = qr.query(sql, new BeanListHandler<User>(User.class), param);
            System.out.println("=====================>");
            System.out.println(list);
            System.out.println("=====================>");
        } catch (SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return list;
    }
}