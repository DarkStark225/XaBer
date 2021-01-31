package Logic;

import org.json.simple.JSONObject;

import java.sql.*;


public class Find {
    public Find(){}

    private final String USERNAME = "admin1";
    private final String PASSWORD = "123456";
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=XaBer";
    private Connection con = null;

    private Connection getConnection (){
        try {
            Class.forName(com.microsoft.sqlserver.jdbc.SQLServerDriver.class.getName());
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }

    public String find (String req){
        JSONObject jsonResp =new JSONObject();
        con = getConnection();
        ResultSet rs;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT Name,Picture,Information " +
                    "from Accords WHERE Name = ?");
            preparedStatement.setString(1,req);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                jsonResp.put("Name",rs.getString("Name"));
                jsonResp.put("Picture",rs.getString("Picture"));
                jsonResp.put("Information",rs.getString("Information"));
            }
            else{
                jsonResp.put("error","not found chord");
            }
            rs.close();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String stringResp = jsonResp.toString();
        return  stringResp;
    }
}
