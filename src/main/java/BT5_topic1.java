import java.util.Scanner;

public class BT5_topic1 {
    //Viết ct nhập chuỗi, chuối có số in ra "có", không có số in ra "không"
    public static void main(String[] args) {
        String chuoi;
        System.out.println("Nhập vào một chuỗi: ");
        Scanner input=new Scanner(System.in);
        chuoi =input.nextLine();
        if (chuoi.matches(".*\\d.*")){
            System.out.println("Chuỗi có số =))");
        }
        else {
            System.out.println("Chuỗi không có số: ");
        }
    }

}
