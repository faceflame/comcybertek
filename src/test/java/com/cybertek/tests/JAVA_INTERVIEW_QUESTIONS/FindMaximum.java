package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

import java.util.Arrays;

/*Write a method that can find the maximum number from an int Array

 */
public class FindMaximum {
    public static void main(String[] args) {

        int arr[]= {2,6,9,4,5,55,3};

        FindMaximum(arr);
        FindMaximum2(arr);

    }

    public static int FindMaximum(int [] arr){

        Arrays.sort(arr);
        int max=arr [arr.length-1];

        System.out.println(max);

        return max; }

        public static int FindMaximum2(int []arr){

        int num= Integer.MAX_VALUE;

            for (int i = 0; i <arr.length ; i++) {

                if(arr[i]<num){
                    num=arr[i];
                    arr[i]=num;

                }

            }
        int max= arr[arr.length-1];

            System.out.println(max);

            return max;
        }

}

