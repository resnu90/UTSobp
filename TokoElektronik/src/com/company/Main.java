package com.company;

import java.util.Scanner;
1
public class Main {

    static Scanner pilihMenu = new Scanner(System.in);
    static TokoElektronik toko = new TokoElektronik();

    public static void main(String[] args) {
        toko.addBarang(new Laptop("Asus", 10000000,100, "SSD 512GB"));
        toko.addBarang(new Laptop("Dell", 15000000,50, "SSD 1TB"));
        toko.addBarang(new Laptop("Acer", 9000000,10, "HDD 1TB"));

        toko.addBarang(new Handphone("Infinix", 1800000,70, "8MP"));
        toko.addBarang(new Handphone("Realme", 2400000,20, "16MP"));
        toko.addBarang(new Handphone("Samsung", 5000000,50, "24MP"));

        Main main = new Main();
        main.run();
    }

    void run() {
        int menu;

        do {
            System.out.println("[][][][] Gadget Store [][][][]");
            System.out.println("[ 1. Beli Barang             ]");
            System.out.println("[ 2. Lihat Stok              ]");
            System.out.println("[ 3. Keluar                  ]");
            System.out.println("[][][][][][][][][][][][][][][]");
            System.out.print("Masukkan pilihan : ");
            menu = pilihMenu.nextInt();

            switch (menu) {
                case 1:
                    toko.beliBarang();
                    break;
                case 2:
                    toko.lihatStok();
                    break;
                case 3:
                    System.out.println("Sampai jumpa lagi :)");
                    break;
                default:
                    System.out.println("Tidak ada dalam menu !");
            }
        } while (menu != 3);
    }
}
