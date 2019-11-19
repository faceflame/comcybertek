package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

import java.util.Arrays;

/*
Write a return method that can sort an int array in Ascending order without using the sort method of the Arrays class
 */
public class SortAscending {
    public static void main(String[] args) {

        int arr []= {1,6,7,-3};
         SortAscending (arr);

        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr.length; j++) {

                if (arr[i]<arr[j]){
                    int temp= arr [i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

/*
          int arr []= {1, 6, 7, -3};
  index positions      0  1  2   3
It2: arr[i=0]=1
           arr[j=1]=6
                        temp=1, arr[i=0]=6, arr[j=1]=1,
                        int arr []= {6, 1, 7, -3};
                index positions      0  1  2   3

It3:  arr[i=0]=6
            arr[j=2]=7
                        temp=6, arr[i=0]=7, arr[j=2]=6,
                        int arr []= {7, 1, 6, -3};
                index positions      0  1  2   3

It4:  arr[i=0]=7
            arr[j=3]=-3
                        temp=6, arr[i=0]=7, arr[j=2]=6,
                        int arr []= {7, 1, 6, -3};
                index positions      0  1  2   3


It5:  arr[i=1]=1
            arr[j=0]=7
                        temp=1, arr[i=1]=7, arr[j=0]=1,
                        int arr []= {1, 7, 6, -3};
                index positions      0  1  2   3

It5:  arr[i=1]=7
            arr[j=1]=7
                        temp=1, arr[i=1]=7, arr[j=0]=1,
                        int arr []= {1, 7, 6, -3};
                index positions      0  1  2   3

It5:  arr[i=1]=7
            arr[j=2]=6
                        temp=1, arr[i=1]=7, arr[j=0]=1,
                        int arr []= {1, 7, 6, -3};
                index positions      0  1  2   3


It5:  arr[i=1]=7
            arr[j=3]=-3
                        temp=1, arr[i=1]=7, arr[j=0]=1,
                        int arr []= {1, 7, 6, -3};
                index positions      0  1  2   3

It6:  arr[i=2]=6
            arr[j=0]=1
                        temp=1, arr[i=2]=7, arr[j=0]=1,
                        int arr []= {1, 7, 6, -3};
                index positions      0  1  2   3


It7:  arr[i=2]=6
            arr[j=1]=7
                        temp=6, arr[i=2]=7, arr[j=1]=6,
                        int arr []= {1, 6, 7, -3};
                index positions      0  1  2   3


It8:  arr[i=2]=7
            arr[j=2]=6
                        temp=6, arr[i=2]=7, arr[j=2]=6,
                        int arr []= {1, 6, 7, -3};
                index positions      0  1  2   3

It9:  arr[i=2]=7
            arr[j=3]=-3
                        temp=6, arr[i=2]=7, arr[j=2]=6,
                        int arr []= {1, 6, 7, -3};
                index positions      0  1  2   3



It10:  arr[i=3]=-3
            arr[j=0]=1
                        temp=-3, arr[i=3]=1, arr[j=0]=-3,
                        int arr []= {-3, 6, 7, 1};
                index positions      0  1  2   3

It11:  arr[i=3]=1
            arr[j=1]=6
                        temp=1, arr[i=3]=6, arr[j=1]=1,
                        int arr []= {-3, 1, 7, 6};
                index positions      0  1  2   3

It11:  arr[i=3]=6
            arr[j=2]=7
                        temp=6, arr[i=3]=7, arr[j=2]=6,
                        int arr []= {-3, 1, 6, 7};
                index positions      0  1  2   3


*/










        SortAscending(arr);

    }

    public static int [] SortAscending (int arr[]){

        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr.length; j++) {

                if (arr[i]<arr[j]){
                    int temp= arr [i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        return arr;
    }
}
