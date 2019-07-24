package com.oa.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * 测试功能：登录
 * 
 * @author Administrator
 *
 */
public class Login {

	// WebAutoTest 被打成了一个jar包

	@Test
	public void testlogin() throws InterruptedException {
		WebAutoTest.openBrowser("http://clicksun.net:311/index.asp", "chrome");
		WebAutoTest.maxBrowser();// 浏览器最大化
		WebAutoTest.switchToFrame(By.xpath("/html/body/table/tbody/tr/td[2]/iframe"));
		WebAutoTest.clickElement(
				By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[4]/td/img[2]"));
		WebAutoTest.clickElement(By.id("page_img"));
		Thread.sleep(2000);

		String s = "//span[text()='我的桌面']";
		WebAutoTest.switchToFrame(By.id("maincontent"));
		Assert.assertEquals(WebAutoTest.getElementText(By.xpath(s)), "我的桌面", "登陆失败");
		WebAutoTest.switchToParentFrame();
	}

	@AfterMethod
	private void afterMethod() throws InterruptedException {
		Thread.sleep(1000);
//		closeAllBrowser(); // 退出驱动并关闭所有关联的窗口
//		WebAutoTest.closeCurrentBrowser();// 关闭当前
	}
}
