package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

import java.util.Arrays;

public class sortDescending {
    public static void main(String[] args) {
        int arr []= {3, -3, 1};

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length ; j++) {

                int temp=0;

                if (arr [i]>arr [j]){
                    temp=arr [i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }

            }

        }

        System.out.println(Arrays.toString(arr));


    }
}
