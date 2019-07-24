package com.oa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 测试：发布公告
 * 
 * @author Administrator
 *
 */
public class PublishNews {

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		new Login().testlogin();
		Thread.sleep(1000);
	}

	@Test
	public void testQuickAnnouncement() throws InterruptedException {
		WebAutoTest.switchToFrame(By.id("left_menu"));

		// 点击 单位新闻管理
		WebAutoTest.clickElement(By.xpath("//td[text()='单位新闻管理']"));

		// 点击 发布新闻
		WebAutoTest.clickElement(By.xpath("/html/body/table/tbody/tr[3]/td/div/div[1]/a/img"));
		Thread.sleep(1000);

		// 跳转iframe,点击 发布部门下拉选择
		WebAutoTest.switchToParentFrame();
		WebAutoTest.switchToFrame(By.id("maincontent"));

		Thread.sleep(1000);

		// 发布人点击 输入张三
		WebAutoTest.clearText(By.name("inputor_name"));
		WebAutoTest.inputText(By.name("inputor_name"), "张三");

		Thread.sleep(1000);

		// 发布部门点击选择 信息中心
		WebAutoTest.clickElement(By.name("senduserdept"));
		WebAutoTest.selectByText(By.name("senduserdept"), "信息中心");

		// 输入文章标题
		WebAutoTest.inputText(By.xpath("//input[@id='title']"), "新闻test");

		Thread.sleep(1000);

		WebAutoTest.switchToParentFrame();
		WebAutoTest.switchToFrame(By.id("maincontent"));
		WebAutoTest.switchToFrame(By.id("ueditor_0"));
		// 输入文章内容

		String text = "<h1>https://www.cnblogs.com/\n</h1>" + "\r\n" + "特殊字符\n" + "\r\n" + "*$(){}+[].?/^|\n" + "\r\n"
				+ "限定字符\n" + "\r\n" + "*+？{n}{n,}{n,m}\n" + "\r\n" + "定位符\n" + "\r\n" + "$^\\b\\B\n" + "\r\n"
				+ "非打印字符\n" + "\r\n" + "\\cf\\f\\n\\\\r\\S\\t\\v\n" + "\r\n" + "<h1>测试</h1>\n" + "\r\n"
				+ "<ahref=\"https://www.baidu.com\">百度</a>";

		Actions actions = new Actions(WebAutoTest.getDriver());
		actions.sendKeys(Keys.TAB).perform(); // 鼠标通过tab要先移到富文本框中
		actions.sendKeys(text).perform();

		WebAutoTest.switchToParentFrame();
		WebAutoTest.switchToFrame(By.id("maincontent"));

		// 点击发布新闻
		WebAutoTest.clickElement(By.id("save_me"));

		Thread.sleep(1000);

		// 弹出框点击确认
		WebAutoTest.acceptAlert();
		Thread.sleep(1000);
		WebAutoTest.acceptAlert();
		WebAutoTest.switchToParentFrame();
	}

	@AfterMethod
	private void afterMethod() throws InterruptedException {
		new Logout().testlogout();
	}
}
