package com.company;

import java.text.DecimalFormat;

public class Handphone extends AlatElektronik {
    private String camera;

    public Handphone(String merk, double harga, int stok, String camera) {
        this.camera = camera;
        setMerk(merk);
        setHarga(harga);
        setStok(stok);
    }

    public void displayInfo() {
        DecimalFormat df = new DecimalFormat(",000.00");

        System.out.println("Informasi Handphone");
        System.out.println("Merk            : " + this.merk);
        System.out.println("Camera          : " + this.camera);
        System.out.println("Harga           : " + df.format(this.harga));
        System.out.println("Sisa Stok       : " + this.stok);
    }
}
