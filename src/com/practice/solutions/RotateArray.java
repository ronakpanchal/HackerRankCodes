package com.practice.solutions;

import java.util.ArrayList;

/**
 * Created by ronak on 9/10/2016.
 */
public class RotateArray {

    public void rotate(ArrayList<ArrayList<Integer>> a) {

        int col=0,row=0;
        int j=0;
        while( col<a.get(0).size()){
            while(row<a.size()){
                swap(a,row,col,col,row);
                row++;
            }
            j++;
            col++;
            row=j;
        }
        for(int i=0;i<a.size();i++){
            int l=0;
            int r=a.get(0).size()-1;
            while(l<r){
                swap(a,i,l,i,r);
                l++;
                r--;
            }
        }

    }
    public void swap(ArrayList<ArrayList<Integer>> a,int i1,int j1,int i2,int j2){
        int temp=a.get(i1).get(j1);
        a.get(i1).set(j1,a.get(i2).get(j2));
        a.get(i2).set(j2,temp);
    }


    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
        RotateArray obj=new RotateArray();
        ArrayList<Integer> a1=new ArrayList<Integer>();
        ArrayList<Integer> a2=new ArrayList<Integer>();
        ArrayList<Integer> a3=new ArrayList<Integer>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a2.add(4);
        a2.add(5);
        a2.add(6);
        a3.add(7);
        a3.add(8);
        a3.add(9);
        a.add(a1);
        a.add(a2);
        a.add(a3);
        obj.rotate(a);
    }
}
