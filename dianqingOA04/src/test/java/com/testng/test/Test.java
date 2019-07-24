package com.testng.test;

import java.util.Scanner;

/***
 * 描述: * 猜数字游戏 * * @author 十三 * @create 2018-12-16 21:50
 */
public class Test {
	public static void main(String[] args) {
		int guest;
		do {
			System.out.print("请输入你猜测的数字：");
			Scanner scanner = new Scanner(System.in);
			guest = scanner.nextInt();
			if (guest < 10) {
				System.out.println("小了");
				guess(guest);
			} else if (guest > 10) {
				System.out.println("大了");
				guess(guest);
			} else {
				System.out.println("YES!");
				guess(guest);
				scanner.close();
			}
		} while (guest != 10);

	}

	public static void guess(int guest) {
		if (guest != 10) {
			System.out.println("继续猜：");
		} else {
			System.out.println("猜对了！");
		}
	}
}
