package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;
public class Reverse {
    /*Write a return method that can reverse  String

Ex: Reverse("ABCD"); ==> DCBA

 */
    public static void main(String[] args) {

        Reverse("KALA");
    }

    public static String Reverse(String a){
        String reverse= "";

        for (int i = a.length()-1; i >=0 ; i--) {
            reverse+=a.charAt(i);
        }
        System.out.println(reverse);

        return reverse;
    }

}
