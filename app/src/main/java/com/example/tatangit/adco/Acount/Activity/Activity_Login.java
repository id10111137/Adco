package com.example.tatangit.adco.Acount.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.Hellper.FrameWork.ApiService;
import com.example.tatangit.adco.Hellper.FrameWork.UtilsApi;
import com.example.tatangit.adco.MainActivity;
import com.example.tatangit.adco.R;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Login extends AppCompatActivity {


    @BindView(R.id.id_username)
    EditText id_username;
    @BindView(R.id.id_password)
    EditText id_password;

    Intent intent;
    Context mContext;
    ApiService mApiService;

    JSONObject jsonRESULTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        if (AdcoManager.getInstance(getApplicationContext()).isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

    }


    @OnClick(R.id.id_btn_login)
    public void goLogin() {

        if (id_username.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nik Belum Terisi", Toast.LENGTH_SHORT).show();
        } else if (id_password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Password Belum Terisi", Toast.LENGTH_SHORT).show();
        } else {
            /*
                Action
             */
            mApiService.loginRequest(id_username.getText().toString(), id_password.getText().toString()).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getBoolean("success")) {

                            UserModel userModel = new UserModel(
                                    jsonRESULTS.getJSONObject("data").get("id_outle").toString(),
                                    jsonRESULTS.getJSONObject("data").get("id_user").toString(),
                                    jsonRESULTS.getJSONObject("data").get("nama_outlet").toString(),
                                    jsonRESULTS.getJSONObject("data").get("first_name").toString(),
                                    jsonRESULTS.getJSONObject("data").get("last_name").toString(),
                                    jsonRESULTS.getJSONObject("data").get("email").toString(),
                                    jsonRESULTS.getJSONObject("data").get("token").toString());

                            AdcoManager.getInstance(mContext.getApplicationContext()).UserLogin(userModel);
                            Intent intent = new Intent(mContext, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            mContext.startActivity(intent);

                        } else {
                            Log.d("Tampil", "Anda Gagal Login");
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(mContext, "Connection Error", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }


}
