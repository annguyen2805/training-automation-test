package javabasic;

import java.util.Scanner;

public class Bai_4 {
    public static void main(String[] args) {
        int max = 0;
        System.out.println("Nhap vao n");
        Scanner number = new Scanner(System.in);
        int n = number.nextInt();
        int[] soNguyen = new int[n];
        System.out.println("nhap vao day so nguyen");
        for (int i = 0; i < n; i++)
            soNguyen[i] = number.nextInt();
        for (int i = 0; i < n; i++) {
            if (soNguyen[i] > max)
                max = soNguyen[i];
        }
        System.out.println("so lon nhat la: " + max);
    }
}
