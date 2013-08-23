package com.netshot.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;

public class DBConnection {

	private String propertiesPath;
	private static String driverClassName;
	private static String url;
	private static String dbUserName;
	private static String dbPassword;

	private static Connection conn;

	static {
		try {
			loadProperties();
			Class.forName(driverClassName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private DBConnection() {

	}

	public static synchronized Connection getConnection() {
		try {
			if (conn == null)
				conn = DriverManager.getConnection(url, dbUserName, dbPassword);

			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean closeAll(ResultSet rs, PreparedStatement pstmt,
			Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			return true;
		} catch (SQLException ex1) {
			System.err.println("Close Failed: " + ex1.getMessage());
			return false;
		}
	}

	private String getPropertiesPath() {
		propertiesPath = System.getProperty("user.dir")
				+ "\\WEB-INF\\jdbc.properties";
		return propertiesPath;
	}

	private static void loadProperties() {
		DBConnection dbConnection = new DBConnection();
		PropertyResourceBundle prb = dbConnection
				.propResourceBundle(dbConnection.getPropertiesPath());
		driverClassName = prb.getString("driverClassName");
		url = prb.getString("url");
		dbUserName = prb.getString("username");
		dbPassword = prb.getString("password");

		System.out.println("url=" + url);
	}

	private PropertyResourceBundle propResourceBundle(String file) {
		BufferedInputStream bis;
		PropertyResourceBundle prs = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			prs = new PropertyResourceBundle(bis);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Can't find the jdbc.properties!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("ERROR: Can't load the jdbc.properties!");
			e.printStackTrace();
		}
		return prs;
	}
}
