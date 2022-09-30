package main;

import accessmodify.HinhTron;

public class HinhTruMain extends HinhTron {
    public float chieuCao;
    public HinhTruMain(float banKinh, float chieuCao) {
        super(banKinh);
        this.chieuCao = chieuCao;
    }
    public float tinhTheTich() {
        return tinhDienTich() * chieuCao;
    }
}
