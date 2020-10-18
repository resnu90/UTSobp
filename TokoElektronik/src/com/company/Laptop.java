package com.company;

import java.text.DecimalFormat;

public class Laptop extends AlatElektronik {
    private String memory;

    public Laptop(String merk, double harga, int stok, String memory) {
        this.memory = memory;
        setMerk(merk);
        setHarga(harga);
        setStok(stok);
    }

    public void displayInfo() {
        DecimalFormat df = new DecimalFormat(",000.00");

        System.out.println("Informasi Laptop");
        System.out.println("Merk            : " + this.merk);
        System.out.println("SSD / HDD       : " + this.memory);
        System.out.println("Harga           : " + df.format(this.harga));
        System.out.println("Sisa Stok       : " + this.stok);
    }
}
