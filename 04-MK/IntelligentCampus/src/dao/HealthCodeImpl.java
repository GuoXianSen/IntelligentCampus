package dao;


import entity.HealthCode;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.MyDB;

import java.sql.SQLException;
import java.util.List;

public class HealthCodeImpl implements IHealthCodeDao{


    /**
     * 删除健康码
     * @param userid
     * @return
     */
    @Override
    public int DeleteHealthCode(int userid) {

        int bool = 0;
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "DELETE FROM healthcode WHERE userid=?;";
        Object[] param = {userid};
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
     * 添加健康码
     * @param hc
     * @return
     */
    @Override
    public HealthCode AddHealthCode(HealthCode hc) {
        HealthCode list = new HealthCode();
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "insert into healthcode(username,healthstatus,healthcodeimg,healthInfo) value(?,?,?,?) ";
        Object[] param = {hc.getUsername(),hc.getHealthstatus(),hc.getHealthcodeimg(),hc.getHealthInfo()};
        try {
            list = qr.insert(sql,new BeanHandler<>(HealthCode.class),param);
            System.out.println("===========================>");
            System.out.println(list);
            System.out.println("===========================>");
        }  catch ( SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 获取所有健康码信息
     * @return
     */
    @Override
    public List<HealthCode> getAllHealthCode() {
        QueryRunner qr = new QueryRunner(MyDB.getDataSource());
        String sql = "select * from healthcode  ";
        Object[] param = {};
        List<HealthCode> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<HealthCode>(HealthCode.class), param);
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
