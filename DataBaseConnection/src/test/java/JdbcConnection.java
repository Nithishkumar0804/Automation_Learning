import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class JdbcConnection {
    public static void main(String[] args) throws SQLException {
        String host="localhost";
        String port="3306";
        String dbName="QADB";
        Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbName,"root","132122");
        Statement stmt=con.createStatement();
        ResultSet rs= stmt.executeQuery("select * from credentials where scenario='ZeroBalanceAccount'");
        rs.next();
        String name=rs.getString("name");
        String password=rs.getString("password");

        //use the data to selenium scripts
    }
}
