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
import com.example.tatangit.adco.Views.Home.Adapter.Adapter_MyProduct;
import com.example.tatangit.adco.Views.Home.Model.Model_MyProduct;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_MyProduct extends Fragment {


    @BindView(R.id.id_cari_myproduct)
    EditText id_cari_myproduct;

    @BindView(R.id.id_my_list_product)
    ListView id_my_list_product;
    UserModel userModel;

    Adapter_MyProduct adapter_myProduct;
    View root;
    ArrayList<Model_MyProduct> model_myProducts;

    Toolbar toolbar;
    CircleImageView toolbar_iconView;
    TextView mTitle;


    public Fragment_MyProduct() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_homes_myproduct, container, false);
        ButterKnife.bind(this, root);
        userModel = AdcoManager.getInstance(getContext()).getUser();

        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("My Product");

        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_sh));



        id_cari_myproduct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String text = id_cari_myproduct.getText().toString().toLowerCase(Locale.getDefault());
                adapter_myProduct.filter(text);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = id_cari_myproduct.getText().toString().toLowerCase(Locale.getDefault());
                adapter_myProduct.filter(text);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        DummyData();
        adapter_myProduct = new Adapter_MyProduct(model_myProducts, getContext());
        id_my_list_product.setAdapter(adapter_myProduct);


        return root;
    }


    private void DummyData() {
        model_myProducts = new ArrayList<>();
        model_myProducts.add(new Model_MyProduct(1, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "BAKSO MANTAPS", "Bakso Malang", 100, 200, "2018-10-10", "", "10000", "50"));
        model_myProducts.add(new Model_MyProduct(2, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "BAKSO GORENG", "Bakso Paijun", 100, 200, "2018-10-10", "", "10000", ""));
        model_myProducts.add(new Model_MyProduct(3, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "NASI GORENG", "Nasi Gorengo Malampir", 100, 200, "2018-10-10", "", "10000", ""));
        model_myProducts.add(new Model_MyProduct(4, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "NASI RAMES", "Nasi Remes Mbah Mijan", 100, 200, "2018-10-10", "", "10000", "100"));
        model_myProducts.add(new Model_MyProduct(5, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "AYAM PENYET", "Ayam Penyet Tatang", 100, 200, "2018-10-10", "", "10000", ""));
        model_myProducts.add(new Model_MyProduct(6, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "ROTI GARMELIA", "Pt. Stanli Indonesia", 100, 200, "2018-10-10", "", "10000", ""));
        model_myProducts.add(new Model_MyProduct(7, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "ROTI SARIROTI", "Pt. Nippon Paint Roti", 100, 200, "2018-10-10", "", "10000", "200"));
        model_myProducts.add(new Model_MyProduct(8, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "ROTI MAKNYUS", "Pt. Teuing Naon", 100, 200, "", "2018-10-10", "10000", ""));
        model_myProducts.add(new Model_MyProduct(9, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "BAKPAU MANIS", "Pt. Boboho", 100, 200, "", "", "10000", "500"));
        model_myProducts.add(new Model_MyProduct(10, "http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png", "MINYAK GORENG", "Cv. Ganda Wijaya", 100, 200, "2018-10-10", "", "10000", "-"));

    }

}
