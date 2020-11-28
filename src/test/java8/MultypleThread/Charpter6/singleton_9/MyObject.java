package java8.MultypleThread.Charpter6.singleton_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/15:41
 * @Description :
 * @Page or WebSite：P404
 * @Expected result ：
 */
public enum MyObject {
    connectionFactory;
    private Connection connection;
    private MyObject() {
        try {
            System.out.println("调用了MyObject的构造");
            String url = "jdbc.....";
            String username = "username";
            String password = "password";
            String drivername = "com.mysql.jdbc.driver";
            Class.forName(drivername);
            DriverManager.getConnection(url, url, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
