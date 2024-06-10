/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 
import java.io.*;
import java.sql.*;

/** 
*@author Aditi
*/
 
public class FirstJDBC {

    public static void main(String[] args) {
        try {
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creating connection
            String url = "jdbc:mysql://localhost:3306/testdata";
            String username = "root";
            String password = "root2023";
            Connection con = DriverManager.getConnection(url, username, password);

            //test connection
            if (con.isClosed()) {
                System.out.println("connection is closed");
            } else {
                System.out.println("connection built...");
            }

            // create query
            String q = "INSERT INTO table1 (tName, tCity) VALUES (?, ?)";

            //get prepared statement object 
            PreparedStatement pstmt = con.prepareStatement(q);

            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter name:");
            String name = br.readLine();

            System.out.println("Enter city:");
            String city = br.readLine();
            
            pstmt.setString(1,name);
            pstmt.setString(2,city);



            // Execute update
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("No data inserted");
            }


             
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
