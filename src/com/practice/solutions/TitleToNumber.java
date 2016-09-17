package com.practice.solutions;

public class TitleToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TitleToNumber obj=new TitleToNumber();
		System.out.println("The column number corresponding to this colum title is "+obj.titleToNumber("AZ"));

	}

	public int titleToNumber(String s) {
		double sum = 0;
		int length = s.length();
		double a = 0;
		double power = 0;
		for (int i = 0; i < length; i++) {
			power = Math.pow(26, length - i - 1);
			a = ((int) s.charAt(i) - 64) * power;
			sum += a;
		}
		return (int)sum;
	}

}
