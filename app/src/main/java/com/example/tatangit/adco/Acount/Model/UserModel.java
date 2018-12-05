package com.example.tatangit.adco.Acount.Model;

/**
 * Created by tatang.it on 11/24/2017.
 */

public class UserModel {

    String id_outle;
    String id_user;
    String nama_outlet;
    String nfirst_name;
    String last_name;
    String email;
    String token;

    public UserModel(String id_outle, String id_user, String nama_outlet, String nfirst_name, String last_name, String email, String token) {
        this.id_outle = id_outle;
        this.id_user = id_user;
        this.nama_outlet = nama_outlet;
        this.nfirst_name = nfirst_name;
        this.last_name = last_name;
        this.email = email;
        this.token = token;
    }

    public String getId_outle() {
        return id_outle;
    }

    public void setId_outle(String id_outle) {
        this.id_outle = id_outle;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama_outlet() {
        return nama_outlet;
    }

    public void setNama_outlet(String nama_outlet) {
        this.nama_outlet = nama_outlet;
    }

    public String getNfirst_name() {
        return nfirst_name;
    }

    public void setNfirst_name(String nfirst_name) {
        this.nfirst_name = nfirst_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }







}
