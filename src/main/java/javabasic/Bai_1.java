package javabasic;

import java.util.Scanner;

public class Bai_1 {
    public static void main(String[] args) {
//        int number;
        System.out.println("Nhap vao mot so: ");
        Scanner a = new Scanner(System.in);
        int number = a.nextInt();
        if (number > 0) {
            System.out.println("so " + number + "  la so nguyen duong");
        } else {
            System.out.println("so " + number + " la so nguyen am");
        }
        a.close();
    }
}
