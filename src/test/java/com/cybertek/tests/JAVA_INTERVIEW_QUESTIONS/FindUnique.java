package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

/*Write a return  method that can find the unique characters from the String

Ex:  unique("AAABBBCCCDEF")  ==>  "DEF";*/
public class FindUnique {

    public static void main(String[] args) {
RemoveDup("AAIDJAOIDJAIJJN");
    }

    public static String RemoveDup(String a){
        String unique="";

        for (int i = 0; i <a.length() ; i++) {
            int count=0;
            for (int j = 0; j <a.length() ; j++) {
                if(a.charAt(i)==a.charAt(j)){
                    count++;
                }
            }
            if(count==1){
                unique+=a.charAt(i) +"";
            }
        }

        System.out.println(unique);

        return unique;}
}

