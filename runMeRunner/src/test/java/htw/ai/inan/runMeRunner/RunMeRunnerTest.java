package htw.ai.inan.runMeRunner;

import static org.junit.Assert.assertEquals;


import org.junit.*;

public class RunMeRunnerTest 
{

	@Test
	public void nonExistingClass() {
		assertEquals("Die Klasse konnte nicht gefunden werden.",RunMeRunner.loadClass("buzzle").toString());
	}
	
	@Test
	public void nonExistingProperty() {
		assertEquals("File oder die darin enthaltenen properties sind nicht korrekt.", RunMeRunner.loadClass(null).toString());
	}
}
