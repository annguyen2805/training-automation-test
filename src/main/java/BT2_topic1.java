import java.util.Scanner;

public class BT2_topic1 {
    //Viết ct kiểm tra 3 số có phải là 3 cạnh của tam giác vuông không
    public static void main(String[] args) {
    float a,b,c;
        System.out.println("Nhập vào 3 số bất kì: ");
        Scanner input=new Scanner(System.in);
        a = input.nextFloat();
        b = input.nextFloat();
        c = input.nextFloat();
        if(a * a == b * b + c * c || b * b == a * a + c * c || c * c == a * a + b * b){
            System.out.println("Đây là 3 cạnh của tam giác vuông");
        }
        else {
            System.out.println("Đây không phải là 3 cạnh của tam giác vuông");
        }
    }
}
