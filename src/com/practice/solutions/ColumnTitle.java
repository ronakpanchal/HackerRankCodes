package com.practice.solutions;

public class ColumnTitle {

	public static void main(String[] args) {
		ColumnTitle obj = new ColumnTitle();
		String result = obj.getColumnTitle(18280);
		System.out.println("The colum title corresponding to given number is "+ result);
	}

	
   
	public String getColumnTitle(int n){
		if(n>26){
			if(n%26==0){
				int k=n/26;
				String s1=(char) (k + 64-1) + "";
				return s1+getColumnTitle(n%26);
			}
			return getColumnTitle(n / 26)+getColumnTitle(n%26);
		}
		else{
			if(n==0){
				return "Z";
			}
			else{
				String s=(char) (n + 64) + "";
				return s;
			}
		}
	}
}
