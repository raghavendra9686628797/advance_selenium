package testNGDemoAnnotationPractice;

import org.testng.annotations.Test;

public class DemoCreateorganizationconfigannotation extends DemoBaseClasss {
	@Test
	public void createOrg() {
		System.out.println("create org");
	}
	@Test
	public void createOrgWithIndustry() {
		System.out.println("create org with industry");
	}
}
