package kethua;

public class Calculation {
    protected int c;
    public void phepCong(int a, int b) {
        c = a + b;
        System.out.println("Tong hai so" +c);
    }
    public void phepTru(int a, int b) {
        c = a-b;
        System.out.println("hieu 2 so" + c);
    }
}
