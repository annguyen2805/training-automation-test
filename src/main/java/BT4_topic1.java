import java.util.Scanner;

public class BT4_topic1 {
    //Viết chưng trình nhập vào n phần tử, sau đó nhập vào n số nguyên dương, tìm phần tử lớn nhất
    public static void main(String[] args) {
    int  n;
    int max =0;
    int[] songuyen;
        System.out.println("Nhập vào độ dài mảng: ");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        songuyen= new int[n];
        for (int i=0; i< n;i++){
            System.out.println("Nhập vào số nguyên: ");
            songuyen[i] = input.nextInt();
        }
        for(int i=0;i< n;i++) {
            if (songuyen[i] > max)
                max = songuyen[i];
        }
        System.out.println("Số lớn nhất là : "+max);
    }
}
