package com.poi.web;

import java.sql.Connection; import java.sql.DriverManager; import org.junit.Test; 
public class MySQLConnectionTest { 
	private static final String DRIVER= "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/estore?serverTimezone=Asia/Seoul&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "deep";
	@Test 
	public void testConnection() throws Exception{ 
		Class.forName(DRIVER); try(
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
			System.out.println(conn); // 콘솔창에서 연결정보를 출력하여 확인한다. } catch (Exception e) { // TODO: handle exception } } }
		}
	}
}

