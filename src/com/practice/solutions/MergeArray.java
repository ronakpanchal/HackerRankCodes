package com.practice.solutions;

public class MergeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={2,4,5,9,9};
		int b[]={0,1,2,3,4};
		int c[]=mergeArrays(a,b);
		for(int i=0;i<c.length;i++){
			System.out.println(c[i]);
		}
	}
   
	static int[] mergeArrays(int[] a, int[] b) {
        int length_a=a.length;
        int length_b=b.length;
        int min=(length_a>length_b)?length_b:length_a;
        int array[]=new int[length_a+length_b];
        int count=0;
        int i=0;//for array a
        int k=0;// for array b
        while(i<min && k<min){
            if(a[i]>b[k]){
                array[count++]=b[k];
                k++;
            }
            else if(a[i]<b[k]){
                array[count++]=a[i];
                i++;
            }
            else{
                array[count++]=a[i];
                array[count++]=b[k];
                i++;
                k++;
            }
        }
        if(i<a.length){
        	while(count<a.length+b.length){
        		array[count++]=a[i];
            	i++;
        	}
        	
        }
        else if(k<b.length){
        	while(count<a.length+b.length){
        		array[count++]=b[k];
            	k++;
        	}
        }
        return array;
 }
}
