package com.oa.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 测试：单位新闻管理-浏览新闻-点击新闻超链接
 * 
 * @author Administrator
 *
 */
public class BrowseNoticeBulletin {

	// 重写switchToCurrentPage
	public static void switchToCurrentPage() {
		String handle = WebAutoTest.getDriver().getWindowHandle();
		for (String tempHandle : WebAutoTest.getDriver().getWindowHandles()) {
			if (tempHandle.equals(handle)) {
//				driver.close();
			} else {
				WebAutoTest.getDriver().switchTo().window(tempHandle);
			}
		}
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		new Login().testlogin();
		Thread.sleep(2000);
	}

	@Test
	public void testBrowseNoticeBulletin() throws InterruptedException {

		WebAutoTest.switchToFrame(By.id("left_menu"));// 跳转iframe
		WebAutoTest.clickElement(By.xpath("//td[text()='通知公告管理']"));// 点击 通知公告管理
		Thread.sleep(1000);
		WebAutoTest.switchToParentFrame();// 回到父iframe
		WebAutoTest.switchToFrame(By.id("maincontent"));// 再次跳转iframe
		WebAutoTest.clickElement(By.xpath("//a[text()='关于加强会议管理的通知']"));// 点击超链接
		Thread.sleep(3000);

		switchToCurrentPage();// 进入当前页
		String ret = WebAutoTest.getElementText(By.xpath("//span[text()='MIS·通知-CD·2009·第【006】号']"));// 获得元素文本
		System.out.println(ret);
		Assert.assertEquals(ret, "MIS·通知-CD·2009·第【006】号", "打开失败");
		Thread.sleep(1000);
		WebAutoTest.maxBrowser();
		Thread.sleep(1000);
		WebAutoTest.setScroll(0, 500);// 下拉滚动

		Thread.sleep(2000);
	}

	@AfterMethod
	private void afterMethod() {
		WebAutoTest.closeCurrentBrowser();// 关闭当前
		WebAutoTest.closeAllBrowser(); // 退出驱动并关闭所有关联的窗口
	}
}
