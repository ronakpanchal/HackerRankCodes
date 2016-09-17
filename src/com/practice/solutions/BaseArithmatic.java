package com.practice.solutions;

import java.util.Scanner;

/**
 * Created by ronak on 8/23/2016.
 */
public class BaseArithmatic {

    public static void main(String[] args){
        BaseArithmatic obj=new BaseArithmatic();
        Scanner stdin = new Scanner(System.in);
        String[] numbers=new String[2];
        int count=0;
        while(count<2)
        {
            numbers[count]=stdin.nextLine();
            count++;
        }
        System.out.println(obj.getSumOfDigits(numbers[0],numbers[1]));

    }

    public long getSumOfDigits(String a,String b){
        long number1=convertToBase10(findMinimumBase(a),a);
        long number2=convertToBase10(findMinimumBase(b),b);

        return number1+number2;
    }

    private long convertToBase10(int base,String number){
        int length=number.length();
        long result=0;
        int numberAtPos=0;
        for(int i=0;i<length;i++){
            numberAtPos=getNumberForCharacter(number.charAt(i));
            result+=(numberAtPos*Math.pow(base,length-i-1));
        }
        return result;
    }

    private int findMinimumBase(String number){
        int maxNumber=0;
        int length=number.length();
        int numberAtPos=0;
        for(int i=0;i<length;i++){
            numberAtPos=getNumberForCharacter(number.charAt(i));
            if(numberAtPos>maxNumber){
                maxNumber=numberAtPos;
            }
        }

        return maxNumber+1;
    }

    private int getNumberForCharacter(char c) {
        if (c == 'A') {
            return 10;
        } else if (c == 'B') {
            return 11;
        } else if (c == 'C') {
            return 12;
        } else if (c == 'D') {
            return 13;
        } else if (c == 'E') {
            return 14;
        } else if (c == 'F') {
            return 15;
        } else {
            return Integer.parseInt(c + "");
        }

    }
}
