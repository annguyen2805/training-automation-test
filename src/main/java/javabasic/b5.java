package javabasic;

import java.util.Scanner;

public class b5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập vào 1 chuỗi: ");
        String chuoi = sc.nextLine();

        System.out.println(chuoi.matches(".*[0-9].*"));
        if(chuoi.matches(".*[0-9].*")){
            System.out.println("Choi co ky tu so");
        }
        else
            System.out.println("Chuoi khong co ky tu so");

//        for (int i = 0; i < chuoi.length(); i++) {
//            char ch = chuoi.charAt(i);
//            int ascii = (int) ch;
//            if(ascii >= 48 && ascii <=57){
//                System.out.println("\nChuỗi có ký tự số");
//                return;
//            }
//        }
//        System.out.println("\nChuỗi không có ký tự số");
    }
}
