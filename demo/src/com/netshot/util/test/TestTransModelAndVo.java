package com.netshot.util.test;
//package csc.osm.util.test;
//
//import java.util.Date;
//
//import csc.osm.action.vo.LoginInfoVO;
//import csc.osm.model.OsmLoginInfo;
//import csc.osm.util.TransVOAndModel;
//
//public class TestTransModelAndVo {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		// transfer model to vo, just can transfer the basic data types
//		OsmLoginInfo loginInfo = new OsmLoginInfo();
//		loginInfo.setLoginId("11111");
//		loginInfo.setLoginTime(new Date());
//		LoginInfoVO loginInfoVO = new LoginInfoVO();
////		loginInfoVO = (LoginInfoVO) TransVOAndModel.transModelAndVO(loginInfo,
//				loginInfoVO);
//		System.out.println(loginInfoVO.getLoginId());
//		System.out.println(loginInfoVO.getLoginTime().toString());
//
//		// transfer vo to model, just can transfer the basic data types
//		LoginInfoVO infoVO = new LoginInfoVO();
//		infoVO.setLoginId("22222");
//		infoVO.setLoginTime(new Date(new Date().getTime() + 100000000));
//		OsmLoginInfo osmLoginInfo = new OsmLoginInfo();
//		osmLoginInfo = (OsmLoginInfo) TransVOAndModel.transModelAndVO(infoVO,
//				osmLoginInfo);
//
//		System.out.println(osmLoginInfo.getLoginId());
//		System.out.println(osmLoginInfo.getLoginTime().toString());
//
//	}
//
//}
