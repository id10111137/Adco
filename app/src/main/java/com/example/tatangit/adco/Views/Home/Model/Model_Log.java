package com.example.tatangit.adco.Views.Home.Model;

public class Model_Log {

    Integer id_log;
    String nama_transkasi;
    String tanggal_transaksi;
    String jam_transaksi;
    Integer Jumlah_transaksi;
    Integer Jumlah_Harga;
    String Karyawan_compute;
    String UrlImage;

    public Model_Log(Integer id_log, String nama_transkasi, String tanggal_transaksi, String jam_transaksi, Integer jumlah_transaksi, Integer jumlah_Harga, String karyawan_compute, String UrlImage) {
        this.id_log = id_log;
        this.nama_transkasi = nama_transkasi;
        this.tanggal_transaksi = tanggal_transaksi;
        this.jam_transaksi = jam_transaksi;
        this.Jumlah_transaksi = jumlah_transaksi;
        this.Jumlah_Harga = jumlah_Harga;
        this.Karyawan_compute = karyawan_compute;
        this.UrlImage = UrlImage;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String UrlImage) {
        this.UrlImage = UrlImage;
    }

    public Integer getId_log() {
        return id_log;
    }

    public void setId_log(Integer id_log) {
        this.id_log = id_log;
    }

    public String getNama_transkasi() {
        return nama_transkasi;
    }

    public void setNama_transkasi(String nama_transkasi) {
        this.nama_transkasi = nama_transkasi;
    }

    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public String getJam_transaksi() {
        return jam_transaksi;
    }

    public void setJam_transaksi(String jam_transaksi) {
        this.jam_transaksi = jam_transaksi;
    }

    public Integer getJumlah_transaksi() {
        return Jumlah_transaksi;
    }

    public void setJumlah_transaksi(Integer jumlah_transaksi) {
        Jumlah_transaksi = jumlah_transaksi;
    }

    public Integer getJumlah_Harga() {
        return Jumlah_Harga;
    }

    public void setJumlah_Harga(Integer jumlah_Harga) {
        Jumlah_Harga = jumlah_Harga;
    }

    public String getKaryawan_compute() {
        return Karyawan_compute;
    }

    public void setKaryawan_compute(String karyawan_compute) {
        Karyawan_compute = karyawan_compute;
    }



}
