package com.main.registre;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;

public class registredao
{
	

	private static String url="jdbc:mysql://localhost:3306/newservlet";
	private static  String userName ="root";
	private static String passWord ="root1234";
	private static String Driver="com.mysql.cj.jdbc.Driver";
	public void loadDriver(String Driver) {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  Connection  getConnection() {
		
		Connection con=null;
		try {
			System.out.println("get coection");
			con=DriverManager.getConnection(url, userName, passWord);
			System.out.println("connectio  establish");
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String insert(Employee emp) {
		
		loadDriver(Driver);
		Connection con=registredao.getConnection();
		String result="data Enter Succcsesfully";
		String sql="insert into newservlet.employee value(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
		if(ps!=null) {
			ps.setString(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getEmail());
		}
			if(ps != null) {
				int noRowsAffected = ps.executeUpdate();
				
				if(noRowsAffected >0) {
					
					return "Welccome.....Data Iserted into Tabble Employee succesfully";
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "failure";
			
		}
		
		
	}

