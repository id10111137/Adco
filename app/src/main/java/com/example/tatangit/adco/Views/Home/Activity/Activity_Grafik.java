package com.example.tatangit.adco.Views.Home.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.R;

import butterknife.ButterKnife;

public class Activity_Grafik extends AppCompatActivity {

    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);
        ButterKnife.bind(this);
        userModel = AdcoManager.getInstance(this).getUser();
        getSupportActionBar().setTitle("My Grafik");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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
