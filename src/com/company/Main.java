package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input, input2;
        ArrayList<Club> members = new ArrayList<Club>();

        for(int i=0;;i++){
            Club one = new Club();
            System.out.println("Welcome to  XYZ Club. Add a New Member? (Y/N)");
            input = scan.nextLine();
            switch (input) {
                case "Y", "y":
                    one.clubMembers();
                    members.add(one);
                    System.out.println("Member added Succesfully");
                    break;
                case "N", "n":
                    System.out.println("Welcome to  XYZ Club. Display club member details? (Y/N)");
                    input2 = scan.nextLine();
                    if (input2.equals("Y") || input2.equals("y")) {
                        Iterator itr = members.iterator();
                        one.memberRuleList(itr);
                        one.memberShow();
                    }
                    break;


                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
    }
}
