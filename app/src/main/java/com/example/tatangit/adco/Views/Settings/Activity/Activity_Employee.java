package com.example.tatangit.adco.Views.Settings.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.Hellper.FrameWork.ApiService;
import com.example.tatangit.adco.Hellper.FrameWork.UtilsApi;
import com.example.tatangit.adco.MainActivity;
import com.example.tatangit.adco.R;
import com.example.tatangit.adco.Views.Home.Adapter.Adapter_MyProduct;
import com.example.tatangit.adco.Views.Home.Model.Model_MyProduct;
import com.example.tatangit.adco.Views.Settings.Adapter.Adapter_Employee;
import com.example.tatangit.adco.Views.Settings.Model.Model_Employee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Employee extends AppCompatActivity {

    UserModel userModel;
    JSONObject jsonRESULTS;
    @BindView(R.id.id_cari_karyawan)
    EditText id_cari_karyawan;

    @BindView(R.id.id_lv_employee)
    ListView id_lv_employee;

    Adapter_Employee adapter_employee;
    Context mContext;
    ApiService mApiService;
    ArrayList<Model_Employee> model_employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_employee);
        ButterKnife.bind(this);
        userModel = AdcoManager.getInstance(this).getUser();
        getSupportActionBar().setTitle("My User");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mApiService = UtilsApi.getAPIService();

        DummyData();
        adapter_employee = new Adapter_Employee(model_employees, getApplicationContext());
        id_lv_employee.setAdapter(adapter_employee);

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


    private void DummyData() {
//        model_employees = new ArrayList<>();
//        model_employees.add(new Model_Employee("1","a","a","a","1","1","1","1","1","1","1"));
//        model_employees.add(new Model_Employee("2","b","b","b","2","2","2","1","1","1","1"));
//        model_employees.add(new Model_Employee("3","c","c","c","3","3","3","1","1","1","1"));
//        model_employees.add(new Model_Employee("4","d","d","d","4","4","4","1","1","1","1"));
//        model_employees.add(new Model_Employee("5","e","e","e","5","5","5","1","1","1","1"));


        mApiService.ListUser(userModel.getId_outle()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                if (jsonRESULTS.getBoolean("status")) {
                    JSONArray result = jsonRESULTS.getJSONArray("data");
                    model_employees = new ArrayList<>();
                    for (int i = 0; i <= result.length(); i++) {
                        JSONObject jsons = result.getJSONObject(i);

                        model_employees.add(new Model_Employee(
                                jsons.getString("id_user"),
                                jsons.optString("id_outlet"),
                                jsons.getString("first_name"),
                                jsons.getString("last_name"),
                                jsons.getString("phone"),
                                jsons.getString("email"),
                                jsons.optString("password"),
                                jsons.optString("level"),
                                jsons.optString("token"),
                                jsons.optString("last_login"),
                                jsons.optString("login")));



                    }

                } else {
                    // Jika login gagal
                    String error_message = jsonRESULTS.getString("error_msg");
                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
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
