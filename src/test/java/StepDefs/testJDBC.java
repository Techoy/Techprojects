package StepDefs;

import Utilities.DBType;
import Utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class testJDBC {

    public static void main (String [] args) throws SQLException {

        DBUtils.establishConnnection(DBType.Oracle);
        System.out.println(DBUtils.countRows("select * from employees"));
        System.out.println(DBUtils.runSQLquely("select max(score)\n" +
                "from scoreTable1"));

        System.out.println(DBUtils.runSQLquely("select max(score) as salary\n" +
                "from scoreTable1"));

        System.out.println(DBUtils.runSQLquely("select max(score) as salary\n" +
                "from scoreTable1").get(0).get("SALARY"));
        System.out.println(DBUtils.runSQLquely("select first_name, salary from employees\n" +
                "where rownum<5\n"));

        List<Map<String , Object>> queryResult=DBUtils.runSQLquely("select first_name, salary from employees\n" +
                "where rownum<5\n");

        for(int i=0; i<queryResult.size(); i++){
            for(String key:queryResult.get(i).keySet()){
                System.out.print(queryResult.get(i).get(key));
            }
            System.out.println();
        }

    }
}
