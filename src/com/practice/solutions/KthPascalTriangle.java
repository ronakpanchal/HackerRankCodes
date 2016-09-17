package com.practice.solutions;

import java.util.ArrayList;

/**
 * Created by ronak on 9/10/2016.
 */
public class KthPascalTriangle {

    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ArrayList<Integer> newList=null;
        if(a==0){
            list.add(1);
            return list;
        }
        else if(a==1){
            list.add(1);
            list.add(1);
            return list;
        }
        else{
            list.add(1);
            list.add(1);

            int count=2;
            newList.add(1);
            while(count<a){
                newList=new ArrayList<Integer>();
                newList.add(1);
                for(int i=1;i<a-1;i++){
                    newList.add(list.get(i)+list.get(i-1));
                }
                newList.add(1);

                list=newList;
                count++;
            }

        }
        return  newList;

    }

    public static void main(String[] arrgs){
        KthPascalTriangle obj=new KthPascalTriangle();
        System.out.println(obj.getRow(3));
    }
}
