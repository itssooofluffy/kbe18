package htw.ai.inan.runMeRunner;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

import htw.ai.inan.propsFileUnit.*;



public class RunMeRunner {
	public static void main(String[] args) {

		String className = PropsFileUtil.readProperties().getProperty("clazz");
		System.out.println(loadClass(className).toString());

	}

	 public static ReturnObject loadClass(String clazzName) {
		int count = 0;
		Object ac = null;
		boolean acNotNull = false;
		ReturnObject obj = new ReturnObject();

		if (clazzName != null) {
			try {
				ac = Class.forName(clazzName).newInstance();
				acNotNull = true;
			} catch (InstantiationException e) {
				obj.exceptionMessage = "Es konnte keine Instanze der Klasse erstellt werden.";
			} catch (IllegalAccessException e) {
				obj.exceptionMessage = "Auf die Klasse kann auf Grund von fehlender Berechtigung nicht zugegriffen werden.";
			} catch (ClassNotFoundException e) {
				obj.exceptionMessage = "Die Klasse konnte nicht gefunden werden.";
			}
		} else {
			obj.exceptionMessage = "File oder die darin enthaltenen properties sind nicht korrekt.";
		}

		if (acNotNull) {
			Method[] methods = ac.getClass().getMethods();
			for (Method method : methods) {
				obj.methodCount++;
				if (method.isAnnotationPresent(RunMe.class)) {
					try {
						method.invoke(ac);
						obj.methodNamesWithRunMe.add(method.getName());
					} catch (IllegalAccessException e) {
						System.out.println(
								"Auf die Methode kann auf Grund von fehlender Berechtigung nicht zugegriffen werden.");
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

				}
			}
		}
		return obj;
	}
}
