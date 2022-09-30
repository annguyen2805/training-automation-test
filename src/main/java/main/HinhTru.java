package accessmodify;

public class HinhTru extends HinhTron{
    public float chieuCao;
    public HinhTru(float banKinh, float chieuCao) {
        super(banKinh);
        this.chieuCao = chieuCao;
    }
    public float tinhTheTich() {
        return tinhDienTich() * chieuCao;
    }
}
