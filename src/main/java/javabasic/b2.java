package javabasic;

import java.util.Scanner;

public class b2 {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thứ 1 : ");
        int a = sc.nextInt();

        System.out.print("Nhập số thứ 2 : ");
        int b = sc.nextInt();

        System.out.print("Nhập số thứ 3 : ");
        int c = sc.nextInt();

        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            System.out.println("Đây không phải là tam giác");
        } else if (a == b && b == c) {
            System.out.println("Đây là tam giác đều");
        } else if (((a * a == b * b + c * c) && b == c) || ((b * b == a * a + c * c) && a == c) || ((c * c == b * b + a * a) && b == a)) {
            System.out.println("Đây là tam giác vuông cân");
        } else if (a == b || b == c || c == a) {
            System.out.println("Đây là tam giác cân");
        } else if ((a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == b * b + a * a)) {
            System.out.println("Đây là tam giác vuông");
        } else if ((a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == b * b + a * a)) {
            System.out.println("Đây là tam giác vuông");
        } else {
            System.out.println("Đây là tam giác thường");
        }
    }
}
