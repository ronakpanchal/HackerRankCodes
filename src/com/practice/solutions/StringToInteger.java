package com.practice.solutions;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger obj = new StringToInteger();
		int number = obj.myAtoi("-0000012333a0569");
		assert number == 12333;
		System.out.println("The number equalivalent to given number is "+ number);
	}

	public int myAtoi(String str) {
		str = str.trim();
		char[] charStr = str.toCharArray();
		if (charStr.length == 0) {
			return 0;
		}
		int lengthOfArgument = charStr.length;
		int number = 0;
		int sum = 0;
		int i = 0;
		int posOfNonZero = getFirstNonZeroCharacter(charStr);
		int posOfNonNumericChar = findFirstNonNumericCharacter(
				charStr);
		if (posOfNonNumericChar != -1) {
			lengthOfArgument = posOfNonNumericChar;
		}
		if (posOfNonZero != -1) {
			if ((int) charStr[posOfNonZero] == 45
					|| (int) charStr[posOfNonZero] == 43) {
				i = posOfNonZero + 1;
			} else {
				i = posOfNonZero;
			}
		} else {
			return 0;
		}

		for (; i < lengthOfArgument; i++) {
			number = (int) charStr[i];
			if (number >= 48 && number <= 57) {

				if ((int) charStr[0] == 45) {
					sum -= Integer.parseInt(charStr[i] + "") * Math
							.pow(10, (lengthOfArgument - i - 1));
				} else if ((int) charStr[0] == 43) {
					sum += Integer.parseInt(charStr[i] + "") * Math
							.pow(10, (lengthOfArgument - i - 1));
				} else {
					sum += Integer.parseInt(charStr[i] + "") * Math
							.pow(10, (lengthOfArgument - i - 1));
				}
			} else {
				sum /= Math.pow(10, (lengthOfArgument - i));
				break;
			}
		}
		return sum;
	}

	private int findFirstNonNumericCharacter(char[] charStr) {
		int lengthOfArray = charStr.length;
		int pos = -1;
		int ascii;
		for (int i = 0; i < lengthOfArray; i++) {
			ascii = (int) charStr[i];
			if ((ascii < 48 || ascii > 57)
					&& !(ascii == 43 || ascii == 45)) {
				pos = i;
				break;
			}
		}
		return pos;

	}

	private int getFirstNonZeroCharacter(char[] charStr) {
		int length = charStr.length;
		int pos = -1;
		int ascii;
		for (int i = 0; i < length; i++) {
			char character = charStr[i];
			ascii = (int) character;
			if (ascii != 48) {
				pos = i;
				break;
			}
		}
		return pos;
	}
}
