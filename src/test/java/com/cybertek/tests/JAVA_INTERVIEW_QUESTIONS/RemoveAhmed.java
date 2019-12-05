package com.cybertek.tests.JAVA_INTERVIEW_QUESTIONS;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveAhmed {

    public static void main(String[] args) {
    ArrayList<String>names= new ArrayList<>(Arrays.asList("Ahmed", "Mehmet", "Ahmed", "Mustafa", "Ahmed"));
    ArrayList<String>newList=new ArrayList<>();


        for (int i = 0; i <names.size() ; i++) {
            if(!names.get(i).equalsIgnoreCase("Ahmed")){
                newList.add(names.get(i));
            }

        }

        System.out.println(newList);



    }
}
