package com.netshot.util.test;
//package csc.osm.util.test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.jsp.jstl.sql.Result;
//
//import csc.osm.action.vo.MemInfoVO;
//import csc.osm.util.DBUtils;
//
//public class TestSearchBySql {
//
//	private String sql;
//
//	public static void main(String[] args) {
//		TestSearchBySql searchBySql = new TestSearchBySql();
//		List<MemInfoVO> list = searchBySql.getMemInfo("");
//		// List<MemInfoVO> list2 = searchBySql.getMemInfo("1001");
//
//		for (MemInfoVO memInfoVO : list) {
//			System.out.println(memInfoVO.getShortName());
//		}
//	}
//
//	public List<MemInfoVO> getMemInfo(String param) {
//		List<MemInfoVO> list = new ArrayList<MemInfoVO>();
//		DBUtils dbUtils = new DBUtils();
//		Result result;
//		if (param == null || param.equals("")) {
//			sql = "select * from OSM_VACA_TYPE t";
//		} else {
//			sql = "select * from OSM_VACA_TYPE WHERE V_TYPE_ID = ? ";
//			List<String> paramlist = new ArrayList<String>();
//			paramlist.add(param);
//			dbUtils.SetSqlParam(paramlist);
//		}
//		dbUtils.SetSql(sql);
//
//		try {
//			result = dbUtils.sql_Select();
//			if (result == null || result.getRowCount() == 0) {
//				System.out.println("No Records");
//			} else {
//				for (int i = 0; i < result.getRowCount(); i++) {
//					MemInfoVO memInfoVO = new MemInfoVO();
//
//					memInfoVO.setShortName(result.getRows()[i]
//							.get("v_type_name").toString());
//					list.add(memInfoVO);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//
//}
