package javabasic;

import java.util.Scanner;

public class b1 {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương:");
        int number = sc.nextInt();
        System.out.println(" \nSố vừa nhập là: " + number);

        if(number >=0){
            System.out.println("Đây là số nguyên dương");
        }
        else
            System.out.println("Đây là số nguyên âm");
    }
}
