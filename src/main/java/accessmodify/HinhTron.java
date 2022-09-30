package accessmodify;

public class HinhTron {
    protected final float PI = 3.14f;
     protected float banKinh;

    //contructor
     public HinhTron(float banKinh) {
        this.banKinh = banKinh;
    }

    protected float tinhChuVi() {
        return 2 * PI * banKinh;
    }
     protected float tinhDienTich() {
        return PI*banKinh*banKinh;
    }
}


