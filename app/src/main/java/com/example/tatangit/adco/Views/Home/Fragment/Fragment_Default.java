package com.example.tatangit.adco.Views.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.R;
import com.example.tatangit.adco.Views.Home.Activity.Activity_Casir;
import com.example.tatangit.adco.Views.Home.Activity.Activity_Grafik;
import com.example.tatangit.adco.Views.Home.Activity.Activity_Printer;
import com.example.tatangit.adco.Views.Home.Activity.Activity_Report;
import com.example.tatangit.adco.Views.Home.Activity.Activity_Store;
import com.example.tatangit.adco.Views.Home.Activity.Activity_Transaksi_Result;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Default extends Fragment {


    @BindView(R.id.imageSlider)
    SliderLayout sliderLayout;
    Intent intent;
    UserModel userModel;

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;

    View root;
    public Fragment_Default() {
        // Required empty public constructor Activity_Transaksi_Result
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_homes_default, container, false);
        ButterKnife.bind(this, root);

        toolbar = getActivity().findViewById(R.id.toolbar);


        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Wellcome To Adco Apps");
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_sh));

        userModel = AdcoManager.getInstance(getContext()).getUser();
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :
        setSliderViews();
        return root;
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png");
                    break;
                case 1:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2015/09/edit-kelapa.png");
                    break;
                case 2:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2014/07/CREAM-CAKE-PANDAN-2-300x212.png");
                    break;
                case 3:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2014/08/family-pack-satuan-cut-resize.png");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getContext(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

    @OnClick(R.id.id_menus_kasir)
    public void goKasir() {
        intent = new Intent(getContext(), Activity_Casir.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_Card_Store)
    public void goStore() {
        intent = new Intent(getContext(), Activity_Store.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_Card_Grafik)
    public void goGrafik() {
        intent = new Intent(getContext(), Activity_Grafik.class);
        startActivity(intent);
    }


    @OnClick(R.id.id_Card_Report)
    public void goReport() {
        intent = new Intent(getContext(), Activity_Report.class);
        startActivity(intent);
    }


    @OnClick(R.id.id_Card_bakso)
    public void goBakso() {
        intent = new Intent(getContext(), Activity_Transaksi_Result.class);
        startActivity(intent);
    }

}
