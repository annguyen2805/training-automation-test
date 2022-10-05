package javabasic;


public class baiThucHanhSo3_buoi2 {
    protected final float Pi=3.14f;
    protected float bankinh;
    //contructor
    public baiThucHanhSo3_buoi2(float bankinh){
        this.bankinh=bankinh;
    }
    protected float tinhChuVi(){
        return 2*Pi*bankinh;
    }
    protected  float tinhDienTich(){
        return bankinh*bankinh*Pi;
    }
}