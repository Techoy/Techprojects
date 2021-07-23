package StepDefs;

import Utilities.Configuration;

import java.sql.*;

public class JDBCConnect {

    public static void main(String[] args) throws SQLException {


        // connection
        //statement
        //ResultTest

        Connection connection= DriverManager.getConnection(Configuration.getProperty("DBURL"),
                Configuration.getProperty("DBUsername"), Configuration.getProperty("DBPassword"));

        Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from employees");
//        resultSet.last();
//        System.out.println(resultSet.getRow());

        while(resultSet.next()){
            System.out.println(resultSet.getString("First_name")+ resultSet.getString("Salary"));
        }

        ResultSetMetaData rsMetsData=resultSet.getMetaData();
        System.out.println(rsMetsData.getColumnCount());
        System.out.println(rsMetsData.getColumnName(1));

        for(int i=0; i<=rsMetsData.getColumnCount(); i++){
            System.out.println(rsMetsData.getColumnName(i));

        }

        while(resultSet.next()){
            for(int i=1; i<=rsMetsData.getColumnCount(); i++){

            }
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
