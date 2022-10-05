package javabasic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Topic_1_JavaBasic {
    public static void baitap1() {
        int number = 0;
        Scanner ip = new Scanner(System.in);
        System.out.print("Nhập số nguyên của bạn: ");
        try {
            number = ip.nextInt();
            if (number >= 0) {
                System.out.println("Đây là số nguyên dương.");
            } else {
                System.out.println("Đây là số nguyên âm.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn phải nhập số nguyên.");
            baitap1();
        }

    }

    public static void baitap2() {
        int canh1 = 0;
        int canh2 = 0;
        int canh3 = 0;
        while (canh1 <= 0) {
            System.out.print("Nhập độ dài cạnh 1 là một số lớn hơn 0: ");
            canh1 = nhapsonguyen();
        }
        while (canh2 <= 0) {
            System.out.print("Nhập độ dài cạnh 2 là một số lớn hơn 0: ");
            canh2 = nhapsonguyen();
        }
        while (canh3 <= 0) {
            System.out.print("Nhập độ dài cạnh 3 là một số lớn hơn 0: ");
            canh3 = nhapsonguyen();
        }
        if (canh1 * canh1 == (canh2 * canh2 + canh3 * canh3)) {
            System.out.println("Đây là 3 cạnh của một tam giác vuông với cạnh huyền có độ dài " + canh1 + ", hai cạnh góc vuông có độ dài là " + canh2 + "," + canh3);
        } else if (canh2 * canh2 == (canh1 * canh1 + canh3 * canh3)) {
            System.out.println("Đây là 3 cạnh của một tam giác vuông với cạnh huyền có độ dài " + canh2 + ", hai cạnh góc vuông có độ dài là " + canh1 + "," + canh3);
        } else if (canh3 * canh3 == (canh1 * canh1 + canh2 * canh2)) {
            System.out.println("Đây là 3 cạnh của một tam giác vuông với cạnh huyền có độ dài " + canh3 + ", hai cạnh góc vuông có độ dài là " + canh1 + "," + canh2);
        } else {
            System.out.println("Đây không phải là 3 cạnh của 1 tam giác vuông");
        }

    }

    public static void baitap3() {
        int n = 0;
        while (n <= 0) {
            System.out.print("Nhập n là số nguyên dương: ");
            n = nhapsonguyen();
        }

        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                result = result + i;
            }
        }
        System.out.println("Tổng các số chẵn trong khoảng từ 0 đến " + n + ": " + result);
    }

    public static int nhapsonguyen() {
        Scanner ip = new Scanner(System.in);
        int n = 0;
        try {
            n = ip.nextInt();
        } catch (InputMismatchException e) {
            n = -1;
        }
        return n;
    }

    public static void baitap4() {
        int n = 0;
        while (n <= 0) {
            System.out.print("Nhập n là số nguyên dương lớn hơn 0: ");
            n = nhapsonguyen();
        }
        int max = 0;
        System.out.println("Nhập dãy số mong muốn:");
        for (int i = 1; i <= n; i++) {
            int check = nhapsonguyen();
            while (check < 0) {
                System.out.print("Bạn phải nhập số nguyên dương.");
                check = nhapsonguyen();
            }
            if (check > max) {
                max = check;
            }
        }
        System.out.println("Phần tử có giá trị lớn nhất là: " + max);

    }

    public static void baitap5() {
        String chuoi = new String();
        Scanner ip = new Scanner(System.in);
        while (chuoi.isEmpty()) {
            System.out.print("Bạn hãy nhập chuỗi: ");
            chuoi = ip.nextLine();
        }
        System.out.print("Chuỗi đã nhập có xuất hiện số hay không?");
        boolean check = false;
        for (int i = 0; i < chuoi.length(); i++) {
            try {
                double d = Double.parseDouble(String.valueOf(chuoi.charAt(i)));
                check = true;
                System.out.print("Có");
                break;
            } catch (NumberFormatException e) {
                check = false;
            }
        }
        if (check == false) {
            System.out.println("Không");
        }

    }

    public static void chonbaitap() {
        Scanner ip = new Scanner(System.in);
        Scanner ip1 = new Scanner(System.in);
        String qa = new String();
        int numberbt = 0;
        try {
            while (numberbt > 5 || numberbt < 1) {
                System.out.print("Bạn hãy nhập bài tập mong muốn từ 1 đến 5: ");
                numberbt = ip.nextInt();
            }
            switch (numberbt) {
                case 1:
                    baitap1();
                    break;
                case 2:
                    baitap2();
                    break;
                case 3:
                    baitap3();
                    break;
                case 4:
                    baitap4();
                    break;
                case 5:
                    baitap5();
                    break;
            }
            System.out.println("Nếu bạn muốn tiếp tục trải nghiệm hãy nhập \"Y\", nếu không hãy nhập bất kỳ kí tự nào.");
            qa = ip1.nextLine();
            if (qa.toUpperCase().equals("Y")) {
                chonbaitap();
            }
        } catch (InputMismatchException e) {
            chonbaitap();
        }
    }

    public static void main(String[] args) {
        chonbaitap();
    }
}
