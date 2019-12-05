package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

import java.util.Arrays;

public class FindMinimum {
    public static void main(String[] args) {
        int arr[] = {5, -3, 6, 99, 78, 3};

        FindMinimum(arr);
        FindMinimum2(arr);

    }

    public static int FindMinimum(int[] arr) {

        Arrays.sort(arr);
        int min = arr[0];

        System.out.println(min);

        return min;
    }

    public static int FindMinimum2(int arr[]) {

        int num = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > num) {
                num = arr[i];
                arr[i] = num;
            }
        }

        int min = arr[0];

        System.out.println(min);

        return min;
    }


}
