package util;

public class RandomGen {
	public static int getRandomNum(int a, int b) {
		return (a>b) ? (int) (Math.random() * (a - b + 1) + b):(int) (Math.random() * (b - a + 1) + a);
	}
}
