package com.example.tatangit.adco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tatangit.adco.Acount.Activity.Activity_Login;
import com.example.tatangit.adco.Hellper.AdcoManager;
import com.example.tatangit.adco.Views.Home.Fragment.Fragment_Homes;
import com.example.tatangit.adco.Views.Help.Fragment_Help;
import com.example.tatangit.adco.Views.Lisensi.Fragment_Lisenci;
import com.example.tatangit.adco.Views.Settings.Fragment.Fragment_Settings;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;
    NavigationView navigationView;

    TextView mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        try {
            if (savedInstanceState == null) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, new Fragment_Homes());
                fragmentTransaction.commit();
            }

            if (!AdcoManager.getInstance(getApplicationContext()).isLoggedIn()) {
                startActivity(new Intent(this, Activity_Login.class));
                finish();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle(
                this, dl, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(t);
        t.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragment = null;

        if (id == R.id.nv_home) {
            fragment = new Fragment_Homes();
        } else if (id == R.id.nav_setting) {
            fragment = new Fragment_Settings();
        } else if (id == R.id.nav_licence) {
            fragment = new Fragment_Lisenci();
        } else if (id == R.id.nav_help) {
            fragment = new Fragment_Help();
        } else if (id == R.id.nav_signout) {
            AdcoManager.getInstance(getApplicationContext()).LogOut();
        } else {
            fragment = new Fragment_Homes();
        }

        goDestination(fragment);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goDestination(Fragment fragment) {
        if (fragment != null) {
            fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }

}
