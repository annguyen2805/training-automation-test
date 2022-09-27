import java.util.Scanner;

public class BT1_topic1 {
    //Viết CT nhập vào số nguyên, số vừa nhập >=0 -> in ra số nguyên dương và ngược lại
    public static void main(String[] args) {
        int n;
        System.out.println("Nhập vào một số nguyên bất kì : ");
        Scanner input=new Scanner(System.in);
        n= input.nextInt();
        if(n>=0){
            System.out.println(n + " Đây là số nguyên dương ");
        }
        else {
            System.out.println(n + " Đây là số nguyên âm ");
        }
    }
}
