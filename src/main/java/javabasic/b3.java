package javabasic;

import java.util.Scanner;

public class b3 {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n : ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i <= n; i=i+2) {
            sum = sum + i;
        }
        System.out.println("Tổng = " + sum);
    }
}
