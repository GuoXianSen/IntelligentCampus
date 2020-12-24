package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyDB {
    private static  ThreadLocal<Connection> local = new ThreadLocal<>();


    public static DataSource getDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        return dataSource;
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConn(){
        Connection conn = local.get();
        try {
            if(conn ==null || conn.isClosed()) {
                conn = getDataSource().getConnection();
                local.set(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接
     */
    public static void close(){
        Connection conn = local.get();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
