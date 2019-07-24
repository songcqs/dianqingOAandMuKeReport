package com.testng.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.WebAutoTest;

public class NoticeExpand {

	@Test
	public void f() throws InterruptedException {
		WebAutoTest.clickElement(By.linkText("在线体验"));
		WebAutoTest.switchToCurrentPage();
		Thread.sleep(3000);
		WebAutoTest.switchToFrame(By.id("left_menu"));
		WebAutoTest.clickElement(By.xpath("//td[text()='通知公告管理']"));
		// 元素“发布通知公告”
		WebElement we = WebAutoTest.findElement(By.id("menu_5"));
		// 判断元素“发布通知公告”是否可见（展开）
		AssertJUnit.assertTrue(we.isDisplayed());
		WebAutoTest.switchToParentFrame();
		WebAutoTest.switchToFrame(By.id("maincontent"));
		Boolean bool = WebAutoTest.isElementExsit(By.xpath("//span[text()='浏览公文/通知']"));
		assertTrue(bool);
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
