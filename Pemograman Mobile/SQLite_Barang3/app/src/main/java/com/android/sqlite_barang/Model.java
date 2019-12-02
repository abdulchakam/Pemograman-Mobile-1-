package com.android.sqlite_barang;

public class Model {
    private int id;
    private String nama;
    private String harga;
    private String ket;
    private byte[] image;

    public Model(int id, String nama, String harga, String ket, byte[] image) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.ket = ket;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}