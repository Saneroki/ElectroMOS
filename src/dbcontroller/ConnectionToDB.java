/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontroller;

import java.sql.*;
import java.util.logging.*;

// java -cp postgresql-9.4-1201.jdbc4.jar:. DBtest

public class ConnectionToDB {
	
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/<INSERT DATABASE HERE>";
		String user = "<INSERT USERNAME HERE>";
		String password = "<INSERT PASSWORD HERE>";
		Connection con = null;

		//CONNECTING
		try {
			con = DriverManager.getConnection(url, user, password);

		} catch (SQLException ex) {
		        Logger lgr = Logger.getLogger(ConnectionToDB.class.getName());
    			lgr.log(Level.WARNING, ex.getMessage(), ex);

		}

		ConnectionToDB(con);
	}

	public static void ConnectionToDB(Connection con){
		//RUN AN EXAMPLE QUERY
		try {
			Statement st = con.createStatement();
		        String query = "select cast (exp(sin(23)*sin(23)+cos(23)*cos(23))*pi()*(exp(sin(23)*sin(23)+cos(23)*cos(23)+sin(23)*sin(23)+cos(23)*cos(23))+cos(pi()/(sin(23)*sin(23)+cos(23)*cos(23)+sin(23)*sin(23)+cos(23)*cos(23))))*(sin(23)*sin(23)+cos(23)*cos(23)+sin(23)*sin(23)+cos(23)*cos(23))/(sin(23)*sin(23)+cos(23)*cos(23)+sin(23)*sin(23)+cos(23)*cos(23)+sin(23)*sin(23)+cos(23)*cos(23)) as int) as answer";
		        ResultSet rs = st.executeQuery(query);
		        while (rs.next()) {
		            	String answer = rs.getString("answer");
		            	System.out.printf("The answer is %s!\n", answer);
		        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}