package com.example.tatangit.adco.Views.Settings.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.adco.R;
import com.example.tatangit.adco.Views.Home.Adapter.Adapter_MyProduct;
import com.example.tatangit.adco.Views.Home.Model.Model_MyProduct;
import com.example.tatangit.adco.Views.Settings.Model.Model_Employee;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Employee extends ArrayAdapter<Model_Employee> {

    private Context context;
    private List<Model_Employee> dataSet = null;
    private ArrayList<Model_Employee> originDataSet = null;
    LayoutInflater inflater;

    public Adapter_Employee(ArrayList<Model_Employee> data, Context context) {
        super(context, R.layout.activity_setting_employee_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {

        TextView id_user;
        TextView id_outlet;
        TextView first_name;
        TextView last_name;
        TextView phone;
        TextView email;
        TextView password;
        TextView level;
        TextView token;
        TextView last_login;
        TextView login;

    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Model_Employee getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final Model_Employee dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_setting_employee_row, parent, false);

//            viewHolder.id_user = convertView.findViewById(R.id.id_user);
//            viewHolder.id_outlet = convertView.findViewById(R.id.id_id_outlet);
            viewHolder.first_name = convertView.findViewById(R.id.id_first_name);
            viewHolder.last_name = convertView.findViewById(R.id.id_last_name);
            viewHolder.phone = convertView.findViewById(R.id.id_phone);
            viewHolder.email = convertView.findViewById(R.id.id_email);
            viewHolder.password = convertView.findViewById(R.id.id_password);
            viewHolder.level = convertView.findViewById(R.id.id_level);
            viewHolder.token = convertView.findViewById(R.id.id_token);
            viewHolder.last_login = convertView.findViewById(R.id.id_last_login);
            viewHolder.login = convertView.findViewById(R.id.id_login);





            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

//        assert dataModel != null;
//        final ImageView img = new ImageView(getContext());
//        Picasso.with(getContext()).load(dataModel.getUrlImage()).into(img, new Callback() {
//            @Override
//            public void onSuccess() {
//                viewHolder.id_ly_image.setBackgroundDrawable(img.getDrawable());
//            }
//
//            @Override
//            public void onError(Exception e) {
//
//            }
//        });


        assert dataModel != null;

        viewHolder.first_name.setText(dataModel.getFirst_name());
        viewHolder.last_name.setText(dataModel.getLast_name());
        viewHolder.phone.setText(dataModel.getPhone());
        viewHolder.email.setText(dataModel.getEmail());
        viewHolder.password.setText(dataModel.getPassword());
        viewHolder.level.setText(dataModel.getLevel());
        viewHolder.token.setText(dataModel.getToken());
        viewHolder.last_login.setText(dataModel.getLast_login());
        viewHolder.login.setText(dataModel.getLogin());

        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (Model_Employee wp : originDataSet) {
                if (wp.getFirst_name().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    dataSet.add(wp);
                } else {

                    Toast.makeText(context, "Data Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }
        }
        notifyDataSetChanged();
    }

}
