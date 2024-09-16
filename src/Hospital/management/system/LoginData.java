package Hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LoginData {
    Connection connection;
    Statement statement;
    public LoginData(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","Aatmaj@3580");
            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
