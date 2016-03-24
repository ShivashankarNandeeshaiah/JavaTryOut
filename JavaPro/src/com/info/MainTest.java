package com.info;

public class MainTest {

	public static void main(String[] args) {

		System.out.println("It starts");
		String straight = "UNIVERSE";
		String reverse;

		char[] test = straight.toCharArray();
		char[] reversed = new char[test.length];
		int length = test.length;
		for (int i = 0; i < test.length; i++) {

			reversed[i] = test[length - 1 - i];

		}
		reverse = reversed.toString();
		System.out.println("Yay it works" + new String(reversed));
	}

}
