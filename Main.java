import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception{


        /**
         * JDBC中将与相关数据库的环境初始化逻辑，封装在了静态代码块中。
         * 要求你在使用某个数据库的JDBC库之间，对该JDBC驱动进行静态代码块的执行。
         *
         * 1. 找出JDBC库中驱动类的位置：com.mysql.jdbc.Driver
         * 2. 使用下面的代码进行静态代码块的执行
         */

        Class.forName("com.mysql.jdbc.Driver");


        /**
         * 这是链接数据库所要使用的url信息，这种格式会根据数据库的不同而不同。
         * 远程主机名：127.0.0.1
         * JDBC 区分: jdbc:mysql
         * 端口号：32768
         * 数据库名：mysql
         *
         * 注意；在url中没有指定用户名和密码。但这未必就意味着不需要在这里指定。
         */
        String url = "jdbc:mysql://192.168.1.21:3306/mysql";
        String username = "root" ;
        String password = "root1234" ;


        /**
         * 使用下面的代码链接数据库。获取到一个数据库连接。
         * 这些代码的执行需要访问网络。哪怕是本地，也需要访问到网络接口卡。
         */
        Connection conn = DriverManager.getConnection(url, username, password);



       query1(conn);
//        query2(conn);
//        insert1(conn);
//        insert2(conn, 2,"Linhua","Wen","朝霞台駅");
//        update(conn, 1,"TOKYO KAWASAKI");
        // delete(conn, 2);
        conn.close();

    }



    private static void query1(Connection conn) throws Exception{
        Statement statement = conn.createStatement();

        String sql = "select * from mysql.user";

        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            String cstId = rs.getString("User");

            System.out.println(cstId);
        }

        rs.close();
        statement.close();
    }

    private static void query2(Connection conn) throws Exception{

        String preparedSql = "select * from mysql.user where Host = ?";

        PreparedStatement statement = conn.prepareStatement(preparedSql);


        int i = 1;
        statement.setString(i++,"localhost");
        statement.setString(i++,"localhost");


        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            String user = rs.getString("User");

            System.out.println(user);
        }

        rs.close();
        statement.close();
    }


    private static void query3(Connection conn) throws Exception{
        String sql = "select * from mysql.user";
        PreparedStatement statement = conn.prepareStatement(sql);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            String user = rs.getString("User");

            System.out.println(user);
        }

        rs.close();
        statement.close();
    }


    private static void insert1(Connection conn) throws Exception {
        String sql = "INSERT into CST (CST_ID, L_NAME, F_NAME, ADDRESS) VALUES (1, 'hao', 'wang', 'TOKYO')";

        Statement statement = conn.createStatement();

        int i = statement.executeUpdate(sql);

        System.out.println("i=" + i);

        statement.close();

    }

    private static void insert2(Connection conn, int cstId, String lastName, String firstName, String addr) throws Exception {
        String sql = "INSERT into CST (CST_ID, L_NAME, F_NAME, ADDRESS) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, cstId);
        statement.setString(2, lastName);
        statement.setString(3, firstName);
        statement.setString(4, addr);

        int i = statement.executeUpdate();

        System.out.println("i=" + i);

        statement.close();

    }

    private static void update(Connection conn, int cstId, String addr) throws Exception {
        String sql = "update CST set ADDRESS = ? where CST_ID = ?";

        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(2, cstId);
        statement.setString(1, addr);

        int i = statement.executeUpdate();

        System.out.println("i=" + i);

        statement.close();

    }

    private static void delete(Connection conn, int cstId) throws Exception {
        String sql = "DELETE FROM CST where CST_ID = ?";

        PreparedStatement statement = conn.prepareStatement(sql);



        statement.setInt(1, cstId);

        int i = statement.executeUpdate();

        System.out.println("i=" + i);

        statement.close();

    }


}