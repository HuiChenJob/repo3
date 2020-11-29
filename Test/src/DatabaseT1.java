import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseT1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/usersql","root","1234");
        System.out.println(connection);
        PreparedStatement prep=connection.prepareStatement("select * from userdata");
//"select * from userdata"可以加入where id=?
//        prep.setString(1,10027);意味第一个？号的条件
        prep.executeQuery();
        ResultSet resultSet=prep.getResultSet();
        while (resultSet.next()){
            String name=resultSet.getString("user_name");
            int age=resultSet.getInt("user_age");
            System.out.println(name+""+age);
        }
    }
}
