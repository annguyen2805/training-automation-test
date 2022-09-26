package javabasic;

import java.util.Scanner;

public class Bai_3_Topic1 {
    public static void main(String[] args)
    {
        int n;
        int sum = 0;
        System.out.println("Nhập vào số nguyên:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i <= n; i++)
            if (i % 2 == 0)
                sum += i;
        System.out.println(sum);
    }
}
