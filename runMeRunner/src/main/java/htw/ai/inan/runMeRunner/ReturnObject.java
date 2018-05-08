package htw.ai.inan.runMeRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReturnObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int methodCount =0;
	List<String> methodNamesWithRunMe = new ArrayList();
	List<String> methodNamesNotInvokable;
	String exceptionMessage = "";

	public ReturnObject() {
	}

	public String toString() {
		if (!exceptionMessage.isEmpty()) {
			return exceptionMessage;
		} else {
			return "There are " + methodNamesWithRunMe.size() + " runnable methods with the RunMe Annotation inside the Class. "
					+ "there are " + methodCount + " methods inside the Class.";
		}
	}

	public int getMethodCount() {
		return methodCount;
	}

	public void setMethodCount(int methodCount) {
		this.methodCount = methodCount;
	}

}
