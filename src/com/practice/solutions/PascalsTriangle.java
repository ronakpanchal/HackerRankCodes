package com.practice.solutions;

import java.util.ArrayList;

/**
 * Created by ronak on 9/7/2016.
 */
public class PascalsTriangle {

    public PascalsTriangle() {
    }

    public static void main(String[] args){
        int a=5;
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1=new ArrayList<Integer>();
        ArrayList<Integer> row2=new ArrayList<Integer>();
        row1.add(1);
        row2.add(1);
        row2.add(1);
        list.add(row1);
        list.add(row2);
        ArrayList<Integer> newList=null;
        for(int i=2;i<a;i++){
            newList=new ArrayList<Integer>();
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i){
                    newList.add(1);
                }
                else{
                    int number_a=list.get(i-1).get(j);
                    int number_b=list.get(i-1).get(j-1);
                    int number=number_a+number_b;
                    newList.add(number);
                }
            }
            list.add(newList);
            newList=null;
        }
    }

}
