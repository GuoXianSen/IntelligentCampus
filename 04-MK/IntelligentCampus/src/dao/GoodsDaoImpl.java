package dao;

import entity.Collect;
import entity.Goods;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.MyDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements IGoodsDao{
    //添加商品信息
    @Override
    public Goods Insert(Goods goods) {
        Goods  list=new Goods();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "insert into goods(goodsname,goodsnum,goodsprice,goodsstatus,createtime,updatedtime,goodscode,goodsimg) value(?,?,?,?,?,?,?,?) ";
        Object[] param = {goods.getGoodsname(),goods.getGoodsnum(),goods.getGoodsprice(),goods.getGoodsstatus(),goods.getCreatetime(),goods.getUpdatedtime(),goods.getGoodscode(),goods.getGoodsimg()};
        try {
            list = qr.insert(sql,new BeanHandler<>(Goods.class),param);
            System.out.println("===========================>");
            System.out.println(list);
            System.out.println("===========================>");
        }  catch ( SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //通过id获取商品信息
    @Override
    public Goods GetGoodsByID(int id) {

        return null;
    }
    //根据商品名获取商品信息
    @Override
    public Goods getGoodsByName(String goodsname) {
        Goods goods = new Goods();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from goods where goodsname=? ";
        Object[] param = {goodsname};
        try {
            goods = qr.query(sql,new BeanHandler<>(Goods.class),param);
            System.out.println(goods);
        }  catch ( SQLException e) {
            e.printStackTrace();

        }
        return goods;
    }
    //获得所有商品记录
    @Override
    public List<Goods> GetAllGoods() {
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from goods ";
        Object[] param = {};
        Goods goods=new Goods();
        List<Goods> list=null;
        try {
             list = qr.query(sql,new BeanListHandler<Goods>(Goods.class),param);
            System.out.println(goods);
        }  catch ( SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //根据商品名密码获取商品信息
    @Override
    public Goods GetGoodsByNamePwd(String username, String password) {
        return null;
    }



    /**
     * 根据商品id删除商品信息
     * @return
     */
    @Override
    public int GoodsDelete(int goodsid) {

        int bool = 0;

        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "DELETE FROM goods WHERE goodsid=?;";
        Object[] param = {goodsid};
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
     * 更新商品信息
     * @param goods
     * @return
     */
    @Override
    public int GoodsUpdate(Goods goods) {
        int bool = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "update goods set goodsname=?,goodsnum=?,goodsprice=?,goodsstatus=?,createtime=?,updatedtime=?,goodscode=?,goodsimg=? where goodsid=?";
        Object[] param = {goods.getGoodsname(),goods.getGoodsnum(),goods.getGoodsprice(),goods.getGoodsstatus(),goods.getCreatetime(),goods.getUpdatedtime(),goods.getGoodscode(),goods.getGoodsimg(),goods.getGoodsid()};
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
    public int findCountGoodsEasy() {
        int count = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select count(0) from goods";
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
    public List<Goods> findGoodsEasyPage(int from, int limitI) {
        List<Goods> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from goods limit ?,?";
        Object[] param = {from, limitI};
        try {
            list = qr.query(sql, new BeanListHandler<Goods>(Goods.class), param);
            System.out.println("=====================>");
            System.out.println(list);
            System.out.println("=====================>");
        } catch (SQLException e) {
            e.printStackTrace();
//            list.setMsg("账号或密码错误！请重新输入！");
        }
        return list;
    }
    //添加收藏
    @Override
    public Collect Addcollect(Collect collect) {
        Collect list=new Collect();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "insert into collect(username,goodsname,goodsprice,goodsimg) value(?,?,?,?) ";
        Object[] param = {collect.getUsername(),collect.getGoodsname(),collect.getGoodsprice(),collect.getGoodsimg()};
        try {
            list =  qr.insert(sql,new BeanHandler<>(Collect.class),param);
            System.out.println("===========================>");
            System.out.println(list);
            System.out.println("===========================>");
        }  catch ( SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //根据用户名获取个人收藏信息
    @Override
    public List<Collect> Getcollect(String username) {
        List<Collect> list=new ArrayList<>();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from collect where username=? ";
        Object[] param = {username};
        try {
            list = qr.query(sql,new BeanListHandler<Collect>(Collect.class),param);
        }  catch ( SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //根据用户名删除收藏
    @Override
    public int Deletecollect(int goodsid) {
        int bool = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "DELETE FROM collect WHERE goodsid=?;";
        Object[] param = {goodsid};
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

}

