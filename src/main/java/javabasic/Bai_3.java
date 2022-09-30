package javabasic;

import java.util.Scanner;

public class Bai_3 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.println("nhap vao so nguyen duong n: ");
        Scanner number = new Scanner(System.in);
        int n = number.nextInt();
        for (int i = 0; i <= n; i++)
            if (i % 2 == 0)
                sum += i;
        System.out.println("tong cac so chan la: " + sum);
    }
}
