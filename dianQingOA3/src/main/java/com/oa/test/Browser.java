package com.oa.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	private String IE;
	private String FireFox;
	private String Chrome;

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		System.setProperty("webdriver.ie.driver", "E:/Javaworkspace/10oaTest/source/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
	}

	public String getFireFox() {
		return FireFox;
	}

	public void setFireFox(String fireFox) {
		System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FireFox = fireFox;
	}

	public String getChrome() {
		return Chrome;
	}

	public void setChrome(String chrome) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
	}

	// 设置浏览器驱动路径
}
