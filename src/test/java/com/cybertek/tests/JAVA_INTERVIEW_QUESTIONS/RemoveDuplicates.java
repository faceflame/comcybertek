package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

public class RemoveDuplicates {
    /*Write a return method that can remove the duplicated values from String

Ex:  removeDup("AAABBBCCC")  ==> ABC
*/

    public static void main(String[] args) {
        String a= "AAABBBCCC";
        String NonDup="";


        for (int i = 0; i <a.length()-1 ; i++) {

            if(!NonDup.contains(a.substring(i, i+1))){
                NonDup+=a.substring(i, i+1);
            }

        }

        System.out.println(NonDup);

    }



}
