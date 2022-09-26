package javabasic;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;


import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Bai_1_Topic1 {
    public static void main(String[] args) {
        int n;
        System.out.println("Nhập vào 1 số nguyên:");
        Scanner sc = new Scanner(System.in);

        n= sc.nextInt();

        if(n>=0){
            System.out.println("Đây là 1 số nguyên dương");
        }else {
            System.out.println("Đây là 1 số nguyên âm");
        }
    }
}