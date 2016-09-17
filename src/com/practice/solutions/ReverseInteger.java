package com.practice.solutions;

/**
 * Created by ronak on 9/11/2016.
 */
public class ReverseInteger {

    public static void main(String[] args){
        ReverseInteger obj=new ReverseInteger();
        int a=obj.reverse(-1234567891);
        System.out.print(a);
    }

    public int reverse(int a) {
        boolean isNegative=false;
        if(a<0){
            isNegative=true;
            a*=-1;
        }
        StringBuilder number=new StringBuilder();
        while(a>0){
            number.append(a%10);
            a=a/10;
        }
        int answer=0;

        try{
            answer=Integer.parseInt(number.toString());
            return isNegative?(answer*-1):answer;
        }catch(NumberFormatException e){
            return 0;
        }
    }
}
