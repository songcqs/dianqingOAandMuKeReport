
package com.oa.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 测试功能：注销
 * 
 * @author Administrator
 *
 */
public class Logout {

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
//		new Login().testlogin();
//		openBrowser("http://clicksun.net:311/index.asp", "firefox");
		WebAutoTest.getCookieByName("%B2%E2%CA%D4%D4%B1");
		WebAutoTest.refreshPage();
		Thread.sleep(2000);
	}

	@Test
	public void testlogout() throws InterruptedException {

//		switchToFrame(By.xpath("//iframe[@name='top_tab']"));// 跳转iframe
		WebAutoTest.clickElement(By.xpath("//span[text()='快捷菜单']"));// 点击 快捷菜单
		WebAutoTest.switchToParentFrame();// 回到父iframe
		WebAutoTest.clickElement(By.xpath("/html/body/div[4]/table/tbody/tr[8]/td/img"));// 点击 退出本系统

		Thread.sleep(2000);
//		closeAllBrowser(); // 退出驱动并关闭所有关联的窗口 
		WebAutoTest.closeCurrentBrowser();// 关闭当前
	}
}