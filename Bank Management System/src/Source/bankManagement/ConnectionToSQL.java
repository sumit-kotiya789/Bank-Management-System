package Source.bankManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionToSQL {
    Statement statement;
    Connection c;

    public ConnectionToSQL(){
        try{
            //Step-1(Create Connection)
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root","sumit");
            //Step-2 Create statement
            statement = c.createStatement();
        }catch (Exception e){
            System.out.println("Exception Occurred: " + e.getMessage());
        }
    }
}
