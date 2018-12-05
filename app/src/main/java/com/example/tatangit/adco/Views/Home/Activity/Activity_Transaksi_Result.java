package com.example.tatangit.adco.Views.Home.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.R;
import com.example.tatangit.adco.Views.Home.Adapter.Adapter_Transaksi_Result;
import com.example.tatangit.adco.Views.Home.Model.Model_Transaksi_Result;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Transaksi_Result extends AppCompatActivity {
    UserModel userModel;

    Adapter_Transaksi_Result adapter_transaksi_result;
    ArrayList<Model_Transaksi_Result> model_transaksi_results ;

    @BindView(R.id.id_edt_cari_result)
    EditText id_edt_cari_result;

    @BindView(R.id.id_transaksi_result)
    ListView id_transaksi_result;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi_result);
        ButterKnife.bind(this);
        userModel = AdcoManager.getInstance(this).getUser();
        getSupportActionBar().setTitle("Transaksi Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        id_edt_cari_result.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String text = id_edt_cari_result.getText().toString().toLowerCase(Locale.getDefault());
                adapter_transaksi_result.filter(text);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = id_edt_cari_result.getText().toString().toLowerCase(Locale.getDefault());
                adapter_transaksi_result.filter(text);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        DummyData();
        adapter_transaksi_result = new Adapter_Transaksi_Result(model_transaksi_results, getApplicationContext());
        id_transaksi_result.setAdapter(adapter_transaksi_result);
    }


    private void DummyData() {
        model_transaksi_results = new ArrayList<>();
        model_transaksi_results =new ArrayList<>();
        model_transaksi_results.add(new Model_Transaksi_Result(1,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso satu","Rasa satu",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(2,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso dua","Rasa dua",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(3,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso tiga","Rasa tiga",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(4,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso empat","Rasa empat",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(5,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso lima","Rasa lima",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(6,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso enam","Rasa enam",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(7,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso tujuh","Rasa delapan",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(8,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso delapan","Rasa sembilan",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(9,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso sembilan","Rasa sepuluh",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(10,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso sepuluh","Rasa sebelas",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(11,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso sebelas","Rasa dua belas",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(12,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso dua belas","Rasa tiga belas",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(13,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso tiga belas","Rasa empat belas",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(14,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso empat belas","Rasa lima belas",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(15,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso lima belas","Rasa enam belas",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(16,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso enam belas","Rasa tujuh belas",10,""));
        model_transaksi_results.add(new Model_Transaksi_Result(17,"http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png","Bakso tujuh belas","Rasa delpan belas",10,""));
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