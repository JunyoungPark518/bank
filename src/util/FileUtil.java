package util;

import java.io.*;
import java.util.Scanner;

public class FileUtil {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File file = new File("C:\\Users\\hb2005\\eclipse\\workspace\\fileiotest.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // 계속 이어 써라
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg = "";
			while(true) {
				System.out.println("[메뉴]0.종료 1.쓰기 2.읽기");
				switch(sc.next()) {
				case "0":
					writer.close();
					return;
				case "1":
					System.out.println("메시지 입력");
					writer.write(sc.next());
					writer.newLine();
					writer.flush();
					break;
				case "2":
					System.out.println("메시지 보기");
					msg=reader.readLine();
					while(msg!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
