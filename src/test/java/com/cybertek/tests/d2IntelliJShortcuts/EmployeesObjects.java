package com.cybertek.tests.d2IntelliJShortcuts;

public class EmployeesObjects {


    public static void main(String[] args) {

        Employee obj2 = new Employee("Madina", "607487", 20, 4532671, "SDET", 850000);
        Employee obj1 = new Employee("Rahwa", "007", 20, 123456, "CEO", 200000);


        obj1.getInfo();
        obj2.getInfo();


    }

}