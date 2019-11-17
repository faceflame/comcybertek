package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

import java.util.Arrays;

/*
Write a return method that can sort an int array in Ascending order without using the sort method of the Arrays class
 */
public class SortAscending {
    public static void main(String[] args) {

        int arr []= {1,6,7,-3,99,0};

        int num = Integer.MAX_VALUE;

        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<num){
                num=arr[i];
                arr[i]=num;
            }

        }

        System.out.println(Arrays.toString(arr));

        SortAscending(arr);

    }

    public static int [] SortAscending (int arr[]){

    int num = Integer.MAX_VALUE;

        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<num){
                num=arr[i];
                arr[i]=num;
            }

        }

        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
