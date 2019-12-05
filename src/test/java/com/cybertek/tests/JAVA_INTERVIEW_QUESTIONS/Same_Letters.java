package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

import java.util.Arrays;

public class Same_Letters {
/*Write a return method that check if a string is build out of the same letters as another string.

Ex:  same("abc",  "cab"); -> true

same("abc",  "abb"); -> false:

 */
public static void main(String[] args) {
    SameLetter("word", "arowd");
}

public static boolean SameLetter(String word, String second){

    boolean outcome=true;

    String [] arr1= word.split("");
    String [] arr2= second.split("");

    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));


    Arrays.sort(arr1);
    Arrays.sort(arr2);

    if (arr1.length!=arr2.length ){
        outcome=false;

    }

    else {

        for (int i = 0; i <word.length() ; i++) {

            if(arr2[i].equals(arr1[i])){
                outcome=true;
            }
            else {
                outcome=false;
            }
        }

    }

    System.out.println(outcome);
    return outcome;
}


}
