package htw.ai.inan.runMeRunner;

public class ClassWithAnnos {
	
	@RunMe()   
	public void startFirstMethod() {
		System.out.println(" die Methoden werden gestartet.");
	}
	   
	public void doNotStartThisMethod(String input) {
	    System.out.println(input + "diese Methode wird nicht gestartet.");
	}
	  
	public int zweiMaldrei(String input, String input_1) {
	      return Integer.parseInt(input) + Integer.parseInt(input_1);
	}
	  
	@RunMe()
	public void add() {
		System.out.println(Integer.parseInt("23") + 7);
	}
}


