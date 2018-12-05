package com.example.tatangit.adco.Views.Home.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.R;
import com.example.tatangit.adco.Views.Home.Adapter.Adapter_Log;
import com.example.tatangit.adco.Views.Home.Adapter.Adapter_MyProduct;
import com.example.tatangit.adco.Views.Home.Model.Model_Log;
import com.example.tatangit.adco.Views.Home.Model.Model_MyProduct;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_LogTransaksi extends Fragment {


    @BindView(R.id.id_cari_homes)
    EditText id_cari_homes;

    @BindView(R.id.id_lv_log)
    ListView id_lv_log;


    UserModel userModel;

    Adapter_Log adapter_log;
    View root;
    ArrayList<Model_Log> model_logs;

    Toolbar toolbar;
    TextView mTitle;

    CircleImageView toolbar_iconView;

    public Fragment_LogTransaksi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_homes_logtransaksi, container, false);
        ButterKnife.bind(this, root);
        userModel = AdcoManager.getInstance(getContext()).getUser();

        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("My Log Transaksi");
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);


        id_cari_homes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String text = id_cari_homes.getText().toString().toLowerCase(Locale.getDefault());
                adapter_log.filter(text);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = id_cari_homes.getText().toString().toLowerCase(Locale.getDefault());
                adapter_log.filter(text);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        DummyData();
        adapter_log = new Adapter_Log(model_logs, getContext());
        id_lv_log.setAdapter(adapter_log);
        return root;
    }


    private void DummyData() {
        model_logs = new ArrayList<>();
        model_logs.add(new Model_Log(1,"Transaksi Payment Mandiri","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(2,"Transaksi Payment BRI","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(3,"Transaksi Payment BCA","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(4,"Transaksi Payment Manual","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(5,"Transaksi Payment Ordenary","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(6,"Transaksi Payment OCBC","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(7,"Transaksi Payment Mandiri","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(8,"Transaksi Payment BCA","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(9,"Transaksi Payment Gojek","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
        model_logs.add(new Model_Log(10,"Transaksi Payment BRI","28-10-2018","23:10:11",20,3000000,"Tatang Roswandi Ganda Wijaya","http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png"));
    }


}
