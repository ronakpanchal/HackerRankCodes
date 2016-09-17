package com.practice.solutions;

import java.util.ArrayList;

/**
 * Created by ronak on 9/10/2016.
 */
public class AntiDiagonals {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int noOfRows=a.size();
        int noOfCols=noOfRows;
        int rownum=0;
        int colnum=0;
        int i=0,j=0;
        ArrayList<Integer> list=null;
        while(colnum<noOfCols){
            j=colnum;
            list=new ArrayList<Integer>();
            i=0;
            while(j>=0 && i<noOfRows){
                list.add(a.get(i).get(j));
                j--;
                i++;
            }
            colnum++;
            result.add(list);
        }
        rownum=1;

        j=noOfCols-1;
        while(rownum<noOfRows){
            i=rownum;
            j=noOfCols-1;
            list=new ArrayList<Integer>();
            while(i<noOfRows && j>=1){
                list.add(a.get(i).get(j));
                j--;
                i++;
            }
            result.add(list);
            rownum++;
        }

        return result;

    }


    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2=new ArrayList<Integer>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        ArrayList<Integer> list3=new ArrayList<Integer>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        a.add(list1);
        a.add(list2);
        a.add(list3);
        AntiDiagonals obj=new AntiDiagonals();
        System.out.print(obj.diagonal(a));
    }
}
