package donggoi;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.setHoTen("Đỗ Thủy CHiều");
        person.setCmnd("0476857657458");
        System.out.println("Họ tên: " + person.getHoTen() + "Chứng minh thư: " + person.getCmnd());
    }
}
