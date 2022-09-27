import java.util.Scanner;

public class BT3_topic1 {
    //Viết ct nhập vào n số nguyên, tính tổng số chẵn trong khoảng từ 0 -> n
    public static void main(String[] args) {
    int n;
    int sum = 0;
        System.out.println("Nhập vào số n: ");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (int i=0;i<=n;i++)
            if (i % 2 == 0)
                sum +=i;
                System.out.println("Tổng các số chẵn trong khoảng 0 đến n là :" + sum);


    }
}
