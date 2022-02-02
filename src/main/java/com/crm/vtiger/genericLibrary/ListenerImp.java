package com.crm.vtiger.genericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * This class provides methods which will take screenshot of failed test case
 * @author rohit
 *
 */

public class ListenerImp implements ITestListener {



	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+testName+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}