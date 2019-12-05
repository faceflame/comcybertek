package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;


/*Write a return method that can find the frequency of characters

Ex:  FrequencyOfChars("AAABBCDD") ==> A3B2C1D2

 */
public class FrequencyOfLetters {
    public static void main(String[] args) {

String input="AAABBCDD";
String output="";


        for (int i = 0; i <input.length() ; i++) {
            if(!output.contains(input.charAt(i)+ "")){
                output+=input.charAt(i);
            }
        }

        System.out.println(output);

        String result="";

        for (int i = 0; i <output.length() ; i++) {
            int count=0;
            for (int j = 0; j <input.length() ; j++) {

                if(input.substring(j, j+1).equals(output.substring(i, i+1))) {
                    count++;

                }

            }

            result+= output.substring(i, i+1) + count;
        }

        System.out.println(result);


    }
}
