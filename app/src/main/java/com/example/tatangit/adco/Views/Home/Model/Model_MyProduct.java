package com.example.tatangit.adco.Views.Home.Model;

public class Model_MyProduct {

    Integer id_myproduct;
    String url_Image;
    String Txt_header;
    String Txt_nama;
    Integer Stock;
    Integer Qty;
    String Txt_TanggalUpdate;
    String Txt_Description;
    String Harga;
    String Promo;


    public Model_MyProduct(Integer id_myproduct, String url_Image, String txt_header, String txt_nama, Integer stock, Integer qty, String txt_TanggalUpdate, String txt_Description, String Harga, String Promo) {
        this.id_myproduct = id_myproduct;
        this.url_Image = url_Image;
        Txt_header = txt_header;
        Txt_nama = txt_nama;
        Stock = stock;
        Qty = qty;
        Txt_TanggalUpdate = txt_TanggalUpdate;
        Txt_Description = txt_Description;
        Harga = Harga;
        Promo =Promo;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getPromo() {
        return Promo;
    }

    public void setPromo(String Promo) {
        Promo = Promo;
    }



    public Integer getId_myproduct() {
        return id_myproduct;
    }

    public void setId_myproduct(Integer id_myproduct) {
        this.id_myproduct = id_myproduct;
    }

    public String getUrl_Image() {
        return url_Image;
    }

    public void setUrl_Image(String url_Image) {
        this.url_Image = url_Image;
    }

    public String getTxt_header() {
        return Txt_header;
    }

    public void setTxt_header(String txt_header) {
        Txt_header = txt_header;
    }

    public String getTxt_nama() {
        return Txt_nama;
    }

    public void setTxt_nama(String txt_nama) {
        Txt_nama = txt_nama;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public String getTxt_TanggalUpdate() {
        return Txt_TanggalUpdate;
    }

    public void setTxt_TanggalUpdate(String txt_TanggalUpdate) {
        Txt_TanggalUpdate = txt_TanggalUpdate;
    }

    public String getTxt_Description() {
        return Txt_Description;
    }

    public void setTxt_Description(String txt_Description) {
        Txt_Description = txt_Description;
    }



}
