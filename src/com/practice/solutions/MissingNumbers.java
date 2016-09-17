package com.practice.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 @author Ronak Panchal
*/
public class MissingNumbers {

    public static void main(String[] args) {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        String a[]={};
        int m;
        String b[]={};
        try{
            n=Integer.parseInt(br.readLine());
            a=br.readLine().split(" ");
            m=Integer.parseInt(br.readLine());
            b=br.readLine().split(" ");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        SortedMap<Integer,Integer> a_frequency=new TreeMap<Integer,Integer>();
        SortedMap<Integer,Integer> b_frequency=new TreeMap<Integer,Integer>();

        for(String number:a){
            int no=Integer.parseInt(number);
            if(a_frequency.get(no)!=null){
                int count=a_frequency.get(no);
                a_frequency.put(no,count+1);
            }
            else{
                a_frequency.put(no,1);
            }
        }



        for(String num:b){
            int item=Integer.parseInt(num);
            int count=0;
            if(b_frequency.get(item)!=null){
                count=b_frequency.get(item);
                b_frequency.put(item,count+1);
            }
            else{
                b_frequency.put(item,1);
            }
        }


        Iterator<Integer> itr1=a_frequency.keySet().iterator();
        Iterator<Integer> itr2=b_frequency.keySet().iterator();
        int no1=0;
        int no2=0;
        while(itr1.hasNext() | itr2.hasNext()){
            if(itr1.hasNext()){
                no1=itr1.next();
                no2=itr2.next();
                int freq1=a_frequency.get(no1);
                int freq2=b_frequency.get(no2);
                if(freq1!=freq2){
                    System.out.print(no2+" ");
                }
            }else
            {
                System.out.print(no2+" ");
            }
        }


    }
}
