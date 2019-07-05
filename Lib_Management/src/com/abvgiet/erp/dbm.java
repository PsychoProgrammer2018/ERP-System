package com.abvgiet.erp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

abstract public class dbm {
PreparedStatement ps;
Connection con;
String query;

public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://104.197.170.26:3306/erp","remote","20314");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}

abstract public void qry();	

public void close() {

	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
