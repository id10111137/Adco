package com.example.tatangit.adco.Views.Home.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Casir extends AppCompatActivity {

    @BindView(R.id.id_edt_full_name)
    EditText id_edt_full_name;
    @BindView(R.id.id_edt_username)
    EditText id_edt_username;
    @BindView(R.id.id_edt_Password)
    EditText id_edt_Password;

    @BindView(R.id.id_txt_header)
    TextView id_txt_header;

    @BindView(R.id.id_btn_save)
    Button id_btn_save;


    Boolean openForm = false;
    UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casir);
        ButterKnife.bind(this);
        userModel = AdcoManager.getInstance(this).getUser();
        getSupportActionBar().setTitle("My Casir");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        openForm(openForm);
        setData();
    }

    @OnClick(R.id.id_btn_save)
    public void goSave() {
        if (openForm == true) {
            Toast.makeText(this, "Oke Lanjut", Toast.LENGTH_SHORT).show();
        } else {
            openForm(true);
        }

    }

    private void setData() {
//        id_edt_full_name.setText(userModel.getNama_user());
//        id_edt_username.setText(userModel.getUsername());
//        id_edt_Password.setText(userModel.getPassword());
//        id_txt_header.setText("Selamat Datang, "+userModel.getNama_user());

    }

    private void openForm(Boolean checkForm) {

        if (!checkForm) {
            id_edt_full_name.setEnabled(false);
            id_edt_username.setEnabled(false);
            id_edt_Password.setEnabled(false);
            id_btn_save.setText("Update");

        } else {
            id_edt_full_name.setEnabled(true);
            id_edt_username.setEnabled(true);
            id_edt_Password.setEnabled(true);
            id_btn_save.setText("Save");
            openForm = true;
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
