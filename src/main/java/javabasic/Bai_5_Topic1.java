package javabasic;

import java.util.Scanner;

public class Bai_5_Topic1 {
    public static void main(String[] args) {
        String chuoi;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào một chuỗi: ");
        chuoi = sc.nextLine();

        if (chuoi.matches(".*\\d.*"))
            System.out.println("Có");
        else
            System.out.println("Không");
    }
}
