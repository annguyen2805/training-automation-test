package javabasic;

import java.util.Scanner;

public class Bai_5 {
    public static void main(String[] args) {
       // String a;
        System.out.println("nhap vao 1 chuoi");
        Scanner str = new Scanner(System.in);
        String a = str.next();
        if (a.matches(".*[0-9].*")) {
            System.out.println("chuỗi " +a+ " CÓ chứa kí tự số");

        } else {
            System.out.println("chuỗi " +a+ " KHÔNG chứa kí tự số");
        }

    }
}
