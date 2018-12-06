package com.example.tatangit.adco.Hellper.FrameWork;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    // http://adco.tericode.com/api/user/login_user
    @FormUrlEncoded
    @POST("user/login_user")
    Call<ResponseBody> loginRequest(@Field("email") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("user/list_user")
    Call<ResponseBody> ListUser(@Field("id_outlet") String id_outlet);

    @FormUrlEncoded
    @POST("user/lihat_outlet")
    Call<ResponseBody> ListOutlet(@Field("id_outlet") String id_outlet);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("user/setting_outlet")
    Call<ResponseBody> SettingOutlet(@Field("id_outlet") String id_outlet,
                                     @Field("nama_outlet") String nama_outlet,
                                     @Field("kota") String kota,
                                     @Field("alamat") String alamat);
}
