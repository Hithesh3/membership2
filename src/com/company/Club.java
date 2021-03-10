package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Club {
    String name,gender;
    int age;
    long donation;
    boolean check;
    Scanner scan = new Scanner(System.in);
    ArrayList<Club> guest = new ArrayList<Club>();
    ArrayList<Club> platinum = new ArrayList<Club>();
    ArrayList<Club> premium = new ArrayList<Club>();
    ArrayList<Club> basic = new ArrayList<Club>();

    void clubMembers(){
        System.out.println("Enter Name");
        this.name= scan.nextLine();
        System.out.println("Enter Age");
        this.age=ageValidate();
        System.out.println("Enter gender(M/F)");
        this.gender=genderValidate();
        System.out.println("Enter donation");
        this.donation=Long.parseLong(scan.nextLine());
    }

    private String genderValidate() {
        String g=null;
        check=false;
        while(!check) {
            String s=scan.nextLine();
            if (s.equals("M") || s.equals("m")) {
                g = "M";
                check=true;
            }
            else if(s.equals("F") || s.equals("f")){
                g="F";
                check=true;
            }
            else{
                System.out.println("Enter valid gender(M/F)");
            }
        }
        return g;
    }

    private int ageValidate() {
        check = false;
        int a=0;
        while (!check) {
            int b = Integer.parseInt(scan.nextLine());
            if (b <= 150) {
                a = b;
                check = true;
            } else {
                System.out.println("Enter valid Age");
            }
        }
        return a;
    }

    public int memberRuleList(Iterator itr) {
        while (itr.hasNext()) {
            Club two = (Club) itr.next();
            if (two.age < 18) {
                guest.add(two);
            } else if (two.donation == 0 && two.gender.equals("M")) {
                guest.add(two);
            } else if (two.donation == 0 && two.gender.equals("F")) {
                premium.add(two);
            } else if (two.donation <= 1000) {
                basic.add(two);
            } else if (two.donation >= 1001 && two.donation <= 49999) {
                premium.add(two);
            } else if (two.donation >= 50000) {
                platinum.add(two);
            } else {
                System.out.println("no rule matched");
                return 0;
            }
        }
        return 0;
    }

    public void memberShow() {
        Iterator itr1=guest.iterator();
        Iterator itr2=basic.iterator();
        Iterator itr3=premium.iterator();
        Iterator itr4=platinum.iterator();
        System.out.println("******XYZ Club******");
        System.out.print("Guest:");
        while(itr1.hasNext()){
            Club two=(Club) itr1.next();
            System.out.println(two.name);
        }
        System.out.print("\nBasic:");
        while(itr2.hasNext()){
            Club two=(Club) itr2.next();
            System.out.println(two.name);
        }
        System.out.print("\nPremium:");
        while(itr3.hasNext()){
            Club two=(Club) itr3.next();
            System.out.println(two.name);
        }
        System.out.print("\nPlatinum:");
        while(itr4.hasNext()){
            Club two=(Club) itr4.next();
            System.out.println(two.name);
        }
        System.out.println("\n");
    }
}
