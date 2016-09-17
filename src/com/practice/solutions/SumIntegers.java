package com.practice.solutions;

/**
 * Created by ronak on 9/16/2016.
 */
public class SumIntegers {

    public static void main(String[] args){
        SumIntegers obj=new SumIntegers();
        int a=-100;//0010
        int b=100;//0011
        int c=0;
        int count=0;
        int d=0;
        int e=0;
        int k=0;
        boolean carry=false;
        int x=0;
        boolean isOperandOneNegative=obj.isOperandNegative(a);
        boolean isOperandTwoNegative=obj.isOperandNegative(b);
        while(count<32){
            d=(a&1);
            e=(b&1);
            if(carry){
                x=(d ^ e) ^ 1;
                c|=x<<count;
                k=1;
            }
            else{
                x=((d ^ e));
                c|=x<<count;
                k=0;
            }
            carry=((d & e) | (d & k) | (e & k))!=0;
            count++;
            a>>=1;
            b>>=1;
        }
        System.out.println(c);

    }
    public boolean isOperandNegative(int number){
        int count=0;
        while(count<32){
            if(count==31){
                if((number & 1)==1){
                    return true;
                }
            }
            count++;
            number>>=2;
        }
        return false;
    }
}
