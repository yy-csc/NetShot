package com.netshot.util;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TransVOAndModel {

	private static final Log log = LogFactory.getLog(TransVOAndModel.class);

	/**
	 * Use to transfer the data between Model and VO. Just can transfer the
	 * Basic data types. If the source Object have a reference of the other
	 * Object. This reference will return null.
	 * 
	 * @param args
	 */
	public static Object transModelAndVO(Object source, Object target) {

		if (source == null || target == null)
			return null;

		Class sourceClass = source.getClass();
		String sourceClassName = sourceClass.getName().substring(
				sourceClass.getName().lastIndexOf(".") + 1);
		Class targetClass = target.getClass();
		String targetClassName = targetClass.getName().substring(
				targetClass.getName().lastIndexOf(".") + 1);

		boolean mark = sourceClassName.startsWith("Osm");

		try {
			Method[] sourceMethods = sourceClass.getDeclaredMethods();
			for (Method method : sourceMethods) {
				if (method.getName().startsWith("get")) {
					Object argModel = executeGetMethod(method, source,
							new Object[] {});
					// System.out.println(mark ? "model:" + argModel : "vo:" + argModel);
					if (argModel != null) {
						executeSetMethod(method, target, argModel);
					}
				}
			}
			log.info((mark ? "------Transfer Model (" : "------Transfer VO (")
					+ sourceClassName + (mark ? ") To Vo (" : ") To Model (")
					+ targetClassName + ") Succeed------");
			return target;
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	private static Object executeGetMethod(Method method,
			Object methodInstance, Object... params) throws Exception {
		return method.invoke(methodInstance, params);
	}

	private static void executeSetMethod(Method method, Object methodInstance,
			Object... params) throws Exception {
		String targetMethodName = "set" + method.getName().substring(3);
		Class targetReturnType = method.getReturnType();
		String targetReturnTypeName = targetReturnType.getName();

		if (targetReturnTypeName.indexOf("Osm") < 0
				&& targetReturnTypeName.indexOf("VO") < 0) {
			try {
				Method targetMethod = methodInstance.getClass().getMethod(
						targetMethodName, targetReturnType);
				targetMethod.invoke(methodInstance, params);
			} catch (NoSuchMethodException e) {
				log.error("NoSuchMethod: (" + targetMethodName + ") in "
						+ methodInstance.getClass().getName());
			}
		}
	}
}
