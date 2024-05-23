package testNGDemoAnnotationPractice;

import org.testng.annotations.Test;

public class DemoCreateContactTestConfigAnnotation extends DemoBaseClasss{
	@Test
	public void createContactTest() {
		System.out.println("create contact");
	}
	@Test
	public void createContactWithDateTest() {
		System.out.println("create contact with date");
	}
}
