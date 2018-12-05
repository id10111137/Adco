package com.example.tatangit.adco.Views.Home.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.Hellper.FrameWork.ApiService;
import com.example.tatangit.adco.Hellper.FrameWork.UtilsApi;
import com.example.tatangit.adco.MainActivity;
import com.example.tatangit.adco.R;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Store extends AppCompatActivity {
    UserModel userModel;

    @BindView(R.id.id_nama_outlet)
    EditText id_nama_outlet;
    @BindView(R.id.id_alamat)
    EditText id_alamat;
    @BindView(R.id.id_kota)
    EditText id_kota;
    @BindView(R.id.id_btn_outlet)
    Button id_btn_outlet;

    public String id_logStore;

    Context mContext;
    ApiService mApiService;

    int Status = 0;
    JSONObject jsonRESULTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        userModel = AdcoManager.getInstance(this).getUser();
        getSupportActionBar().setTitle("My Store");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        doForm(Status);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        getDataOutlet(Status);



    }


    private void getDataOutlet(int Statuss){

        if(Statuss == 0){
            mApiService.ListOutlet(userModel.getId_outle()).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        jsonRESULTS = new JSONObject(response.body().string());
                        if (jsonRESULTS.getBoolean("success")) {
                            id_logStore = jsonRESULTS.getJSONObject("data").get("id").toString();
                            id_nama_outlet.setText(jsonRESULTS.getJSONObject("data").get("nama_outlet").toString());
                            id_kota.setText(jsonRESULTS.getJSONObject("data").get("kota").toString());
                            id_alamat.setText(jsonRESULTS.getJSONObject("data").get("alamat").toString());
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
        }else{

            mApiService.SettingOutlet(id_logStore, id_nama_outlet.getText().toString(), id_kota.getText().toString(), id_alamat.getText().toString()).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        jsonRESULTS = new JSONObject(response.body().string());
                        Log.d("Tampil"," "+jsonRESULTS.getJSONObject("data"));
                        finish();
                        startActivity(getIntent());

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


    @OnClick(R.id.id_btn_outlet)
    public void goUpdateOutlet() {

        if(Status == 2){
            Toast.makeText(mContext, "ini baru ok", Toast.LENGTH_SHORT).show();
            getDataOutlet(1);
        }else{
            doForm(1);
        }

    }

    private void doForm(int Statuss) {

        if (Statuss == 0) {
            id_nama_outlet.setEnabled(false);
            id_alamat.setEnabled(false);
            id_kota.setEnabled(false);
            id_btn_outlet.setText("Update");
        } else {
            id_nama_outlet.setEnabled(true);
            id_alamat.setEnabled(true);
            id_kota.setEnabled(true);
            Status = 2;
            id_btn_outlet.setText("Simpan");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
