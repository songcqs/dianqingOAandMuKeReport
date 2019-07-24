package com.testng.test;

import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.WebAutoTest;

/**
 * 测试：打开OA进入主页
 * 
 * @author Administrator
 *
 */
public class OpenOA {
	@Test
	public void f() throws InterruptedException {
		WebAutoTest.clickElement(By.linkText("在线体验"));
		WebAutoTest.switchToCurrentPage();
		Thread.sleep(3000);
		AssertJUnit.assertEquals(WebAutoTest.getURL(), "http://clicksun.net:311/mis/csun.html");
	}

	@BeforeMethod
	public void beforeMethod() {
		WebAutoTest.openBrowser("http://oa.clicksun.cn/casc/question.htm", "chrome");
	}

	@AfterMethod
	public void afterMethod() {
		WebAutoTest.closeAllBrowser();
	}

}
