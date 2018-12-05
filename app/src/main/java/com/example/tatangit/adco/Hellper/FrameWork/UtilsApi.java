package com.example.tatangit.adco.Hellper.FrameWork;

public class UtilsApi {

    public static final String BASE_URL_API = "http://adco.tericode.com/api/";

    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }


}
