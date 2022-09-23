package javabasic;

import java.util.Scanner;

public class b4 {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n : ");
        int n = sc.nextInt();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập phần tử thứ " +i+ " : ");
            int a = sc.nextInt();
            if(a > max){
                max = a;
            }
        }
        System.out.println("\nSố lớn nhất = " +max );
    }
}
