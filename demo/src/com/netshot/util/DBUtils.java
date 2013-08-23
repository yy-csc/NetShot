package com.netshot.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class DBUtils {

	private Connection conn;
	private String sql;
	private List<String> list;

	public DBUtils() {
		this.conn = DBConnection.getConnection();
	}

	public void SetConnection(Connection conn) {
		if (conn == null)
			this.conn = DBConnection.getConnection();
		else
			this.conn = conn;
	}

	public void SetSql(String strsql) {
		this.sql = strsql;
	}

	public void SetSqlParam(List<String> list) {
		this.list = list;
	}

	public void SetSqlParam(PreparedStatement pstmt, List<String> list)
			throws SQLException {
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			pstmt.setObject(i + 1, obj);
		}
	}

	public Result sql_Select() {
		Result result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			if (list != null && list.size() > 0) {
				pstmt = conn.prepareStatement(sql);
				SetSqlParam(pstmt, list);
				rs = pstmt.executeQuery();
			} else {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			}
			result = ResultSupport.toResult(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(rs, pstmt, stmt, conn);
		}
		return result;
	}

	public int sql_Update() throws SQLException {
		int num = 0;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			if (list != null && list.size() > 0) {
				pstmt = conn.prepareStatement(sql);
				SetSqlParam(pstmt, list);
				num = pstmt.executeUpdate();
			} else {
				stmt = conn.createStatement();
				num = stmt.executeUpdate(sql);
			}
		} finally {
			DBConnection.closeAll(rs, pstmt, stmt, conn);
		}
		return num;
	}
}
