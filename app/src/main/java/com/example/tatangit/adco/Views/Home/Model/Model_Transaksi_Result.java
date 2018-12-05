package com.example.tatangit.adco.Views.Home.Model;

import de.hdodenhof.circleimageview.CircleImageView;

public class Model_Transaksi_Result {

    int id_transkasi_result;
    String UrlImage;
    String id_header_Result;
    String id_jenis_bakso;
    int id_sisa_stock;
    String Harga;

    public Model_Transaksi_Result(int id_transkasi_result, String urlImage, String id_header_Result, String id_jenis_bakso, int id_sisa_stock, String harga) {
        this.id_transkasi_result = id_transkasi_result;
        this.UrlImage = urlImage;
        this.id_header_Result = id_header_Result;
        this.id_jenis_bakso = id_jenis_bakso;
        this.id_sisa_stock = id_sisa_stock;
        this.Harga = harga;
    }

    public int getId_transkasi_result() {
        return id_transkasi_result;
    }

    public void setId_transkasi_result(int id_transkasi_result) {
        this.id_transkasi_result = id_transkasi_result;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }

    public String getId_header_Result() {
        return id_header_Result;
    }

    public void setId_header_Result(String id_header_Result) {
        this.id_header_Result = id_header_Result;
    }

    public String getId_jenis_bakso() {
        return id_jenis_bakso;
    }

    public void setId_jenis_bakso(String id_jenis_bakso) {
        this.id_jenis_bakso = id_jenis_bakso;
    }

    public int getId_sisa_stock() {
        return id_sisa_stock;
    }

    public void setId_sisa_stock(int id_sisa_stock) {
        this.id_sisa_stock = id_sisa_stock;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }

}
