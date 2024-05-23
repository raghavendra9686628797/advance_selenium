package com.comcast.crm.orgtest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.OrganizationPage;
import com.crm.comcast.genericBaseutility.BaseClass_new;

public class CreateOrganizationTESTNG_Test extends BaseClass_new {
	@Test
	public void createorgtestcase() throws IOException, InterruptedException {
		
		
	
	
		
		//read data from property file
		HomePage hlib=new HomePage(driver);
		hlib.getOrganizaton().click();
		//click on create new organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getAddOrganizationButton().click();
		
		Thread.sleep(2000);
		
	}
}
