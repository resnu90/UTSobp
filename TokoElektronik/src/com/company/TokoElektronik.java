package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TokoElektronik implements Toko {
    private Scanner inputNum = new Scanner(System.in);
    private Scanner inputStr = new Scanner(System.in);
    private ArrayList<Laptop> arrLaptop = new ArrayList<>();
    private ArrayList<Handphone> arrHandphone = new ArrayList<>();

    private String search, type;
    private int found;

    void addBarang(Laptop laptop) {
        arrLaptop.add(laptop);
    }

    void addBarang(Handphone handphone) {
        arrHandphone.add(handphone);
    }

    @Override
    public void lihatStok() {
        System.out.println("\nGadget Store - Stok Laptop\n");
        for (Laptop laptop : arrLaptop) {
            laptop.displayInfo();
            System.out.println();
        }

        System.out.println("\nGadget Store - Stok Handphone\n");
        for (Handphone handphone : arrHandphone) {
            handphone.displayInfo();
            System.out.println();
        }
    }

    public int searchLaptop(String search) {
        for (int i = 0; i < arrLaptop.size(); i++) {
            if (arrLaptop.get(i).getMerk().equalsIgnoreCase(search)) {
                return i;
            }
        }
        return -1;
    }

    public int searchHandphone(String search) {
        for (int i = 0; i < arrHandphone.size(); i++) {
            if (arrHandphone.get(i).getMerk().equalsIgnoreCase(search)) {
                return i;
            }
        }
        return -1;
    }

    public void summary(Laptop laptop) {
        System.out.println();
        laptop.displayInfo();
    }

    public void summary(Handphone handphone) {
        System.out.println();
        handphone.displayInfo();
    }


    @Override
    public void beliBarang() {
        System.out.println("Dream Gadget Store - Penjualan");
        System.out.println("=-=-=->");
        System.out.println("1. Laptop");
        System.out.println("2. Handphone");
        System.out.print("Pilih barang : ");
        int pilih = inputNum.nextInt();
        switch (pilih) {
            case 1:
                type = "Laptop";
                System.out.print("Merk Laptop : ");
                search = inputStr.nextLine();
                found = searchLaptop(search);
                if (found != -1)
                    summary(arrLaptop.get(found));
                else
                    System.out.println("Merk laptop tidak ditemukan");
                break;
            case 2:
                type = "Handphone";
                System.out.print("Merk Handphone : ");
                search = inputStr.nextLine();
                found = searchHandphone(search);
                if (found != -1)
                    summary(arrHandphone.get(found));
                else
                    System.out.println("Merk Handphone tidak ditemukan");
                break;
            default:
                System.out.println("Tidak ada produk yang dipilih");
        }

        if (found != -1 && type.equals("Laptop")) {
            System.out.print("\nJumlah yang ingin dibeli : ");
            int jumlah = inputNum.nextInt();
            if (jumlah > arrLaptop.get(found).getStok()) {
                System.out.println("Maaf, Stok Tidak Mencukupi");
            } else {
                // Ubah stok
                arrLaptop.get(found).setStok(arrLaptop.get(found).getStok() - jumlah);

                // Cari diskon
                double diskon = 0;
                if (jumlah < 1) {
                    System.out.println("Error: Jumlah minimal 1");
                } else if (jumlah < 2) {
                    diskon = 0;
                } else if (jumlah < 6) {
                    diskon = 1;
                } else {
                    diskon = 2;
                }

                // Hitung harga
                double totalHarga = arrLaptop.get(found).getHarga() * jumlah;
                double hargaDiskon = totalHarga * diskon / 100;

                // Tampilkan rincian
                DecimalFormat df = new DecimalFormat(",000.00");

                System.out.println("\nMerk         : " + arrLaptop.get(found).getMerk());
                System.out.println("Harga Satuan : " + df.format(arrLaptop.get(found).getHarga()));
                System.out.println("Jumlah Beli  : " + jumlah);
                System.out.println("Total Harga  : " + df.format(totalHarga));
                System.out.println("Diskon       : " + diskon + " %");
                System.out.println("Total Diskon : " + df.format(hargaDiskon));
                System.out.println("Total Bayar  : " + df.format((totalHarga - hargaDiskon)));
                System.out.println();
            }
        }
        if (found != -1 && type.equals("Handphone")) {
            System.out.print("\nJumlah yang ingin dibeli : ");
            int jumlah = inputNum.nextInt();
            if (jumlah > arrHandphone.get(found).getStok()) {
                System.out.println("Maaf, Stok Tidak Mencukupi");
            } else {
                // Ubah stok
                arrHandphone.get(found).setStok(arrHandphone.get(found).getStok() - jumlah);

                // Cari diskon
                double diskon = 0;
                if (jumlah < 1) {
                    System.out.println("Error: Jumlah minimal 1");
                } else if (jumlah < 2) {
                    diskon = 0;
                } else if (jumlah < 6) {
                    diskon = 1;
                } else {
                    diskon = 2;
                }

                // Hitung harga
                double totalHarga = arrHandphone.get(found).getHarga() * jumlah;
                double hargaDiskon = totalHarga * diskon / 100;

                // Tampilkan rincian
                DecimalFormat df = new DecimalFormat(",000.00");

                System.out.println("\nMerk         : " + arrHandphone.get(found).getMerk());
                System.out.println("Harga Satuan : " + df.format(arrHandphone.get(found).getHarga()));
                System.out.println("Jumlah Beli  : " + jumlah);
                System.out.println("Total Harga  : " + df.format(totalHarga));
                System.out.println("Diskon       : " + diskon + " %");
                System.out.println("Total Diskon : " + df.format(hargaDiskon));
                System.out.println("Total Bayar  : " + df.format((totalHarga - hargaDiskon)));
                System.out.println();
            }
        }


    }
}
