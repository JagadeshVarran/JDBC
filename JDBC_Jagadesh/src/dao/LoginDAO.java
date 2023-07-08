package dao;

import java.sql.*;

 

import ConnectionManager.ConnectionManager;

import model.Login;

public class LoginDAO

{

                public boolean validate(Login login) throws ClassNotFoundException,SQLException

                {

                               

                                String username=login.getUsername();

                                String password=login.getPassword();

                               

                                ConnectionManager conn = new ConnectionManager();

                                Connection con = conn.establishmentConnection();

                               

                                Statement st= con.createStatement();

                               

                                ResultSet rs=st.executeQuery("select  *from login");

                               

                                while(rs.next())

                                {

                                                if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password")))

                                                {

                                                                conn.closeconnection();

                                                                return true;

                                                }

                                }

                               

                                conn.closeconnection();

                                return false;

                                               

                }

               

}

