package StepDefs;

import Utilities.Configuration;
import Utilities.DBType;
import Utilities.DBUtils;

import java.sql.*;
import java.util.TimeZone;

public class JDBCREcap {

    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/techtoriDB44ioz?serverTimezone="+ TimeZone.getDefault().getID(), "techtoriDB44ioz", "Z1V0m8ma8S");


        Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from wp_posts");
        while(resultSet.next()){
            if(resultSet.getString("id").equals("7")) {


                System.out.println(resultSet.getString("id") + " " + resultSet.getString("post_title")+resultSet.getString("post_content"));
            }
        }



    }
}
