package com.example.tatangit.adco.Hellper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.tatangit.adco.Acount.Activity.Activity_Login;
import com.example.tatangit.adco.Acount.Model.UserModel;
import com.example.tatangit.adco.MainActivity;


/**
 * Created by tatang.it on 11/24/2017.
 */

public class AdcoManager {

    private static AdcoManager mInstance;
    private static Context mContext;

    private AdcoManager(Context context) {
        mContext = context;
    }

    public static synchronized AdcoManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new AdcoManager(context);
        }
        return mInstance;
    }

    public void UserLogin(UserModel userModel) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(DataCollection.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DataCollection.KEY_id_outle, userModel.getId_outle());
        editor.putString(DataCollection.KEY_id_user, userModel.getId_user());
        editor.putString(DataCollection.KEY_nama_outlet, userModel.getNama_outlet());
        editor.putString(DataCollection.KEY_nfirst_name, userModel.getNfirst_name());
        editor.putString(DataCollection.KEY_email, userModel.getLast_name());
        editor.putString(DataCollection.KEY_email, userModel.getEmail());
        editor.putString(DataCollection.KEY_email, userModel.getToken());


        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(DataCollection.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(DataCollection.KEY_id_user, null) != null;
    }

    public UserModel getUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(DataCollection.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UserModel(
                sharedPreferences.getString(DataCollection.KEY_id_outle, null),
                sharedPreferences.getString(DataCollection.KEY_id_user, null),
                sharedPreferences.getString(DataCollection.KEY_nama_outlet, null),
                sharedPreferences.getString(DataCollection.KEY_nfirst_name, null),
                sharedPreferences.getString(DataCollection.KEY_last_name, null),
                sharedPreferences.getString(DataCollection.KEY_email, null),
                sharedPreferences.getString(DataCollection.KEY_token, null));

    }

    public void LogOut() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(DataCollection.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        Intent intent = new Intent(mContext, Activity_Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public void Refresh() {
        mContext.startActivity(new Intent(mContext, MainActivity.class));
        return;
    }

}
