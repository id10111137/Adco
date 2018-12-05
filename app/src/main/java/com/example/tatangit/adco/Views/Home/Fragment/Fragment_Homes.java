package com.example.tatangit.adco.Views.Home.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_Homes extends Fragment {


    @BindView(R.id.btn_navigation_mInfo)
    BottomNavigationView btn_navigation_mInfo;
    View root;
    UserModel userModel;
    Fragment fragment;

    public Fragment_Homes() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_homes, container, false);
        ButterKnife.bind(this, root);
        userModel = AdcoManager.getInstance(getContext()).getUser();
        setupNavigationView();
        return root;
    }


    private void setupNavigationView() {

        if (btn_navigation_mInfo != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = btn_navigation_mInfo.getMenu();
            selectmInfo(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            btn_navigation_mInfo.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectmInfo(item);
                            return false;
                        }
                    });
        }
    }


    protected void selectmInfo(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.mHomes:
                pushFragment(new Fragment_Default());
                break;
            case R.id.mMyProduct:
                pushFragment(new Fragment_MyProduct());
                break;
            case R.id.mLogTransaksi:
                pushFragment(new Fragment_LogTransaksi());
                break;
        }
    }


    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.frame_homes, fragment);
                ft.commit();
            }
        }
    }


}
