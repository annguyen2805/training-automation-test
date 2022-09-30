package javabasic;

import java.util.Scanner;

public class Bai_2 {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Nhap vao 3 so: ");
        System.out.println("Nhap vao so a: ");
        Double a = number.nextDouble();
        System.out.println("Nhap vao so b: ");
        Double b = number.nextDouble();
        System.out.println("Nhap vao so c: ");
        Double c = number.nextDouble();
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Day la 3 canh cua 1 tam giac");
            if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)) {
                System.out.println("Day la tam giac vuong");
            } else {
                System.out.println("day khong la tam giac vuong");
            }
        } else {
            System.out.println("day khong phai la ba canh cua 1 tam giac");
        }

    }
}

