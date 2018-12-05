package com.example.tatangit.adco.Views.Home.Adapter;

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
import com.example.tatangit.adco.Views.Home.Model.Model_Log;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Log extends ArrayAdapter<Model_Log> {

    private Context context;
    private List<Model_Log> dataSet = null;
    private ArrayList<Model_Log> originDataSet = null;
    LayoutInflater inflater;

    public Adapter_Log(ArrayList<Model_Log> data, Context context) {
        super(context, R.layout.activity_homes_myproduct_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {
        ImageView id_image_log;
        TextView id_nama_transaksi;
        TextView id_tanggal_transaksi;
        TextView id_jumlah_items;
        TextView id_total_harga;
        TextView id_jam_log_transaksi;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Model_Log getItem(int position) {
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
        final Model_Log dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_homes_logtransaksi_row, parent, false);

            viewHolder.id_image_log = convertView.findViewById(R.id.id_image_log);
            viewHolder.id_nama_transaksi = convertView.findViewById(R.id.id_nama_transaksi);
            viewHolder.id_tanggal_transaksi = convertView.findViewById(R.id.id_tanggal_transaksi);
            viewHolder.id_jumlah_items = convertView.findViewById(R.id.id_jumlah_items);
            viewHolder.id_total_harga = convertView.findViewById(R.id.id_total_harga);
            viewHolder.id_jam_log_transaksi = convertView.findViewById(R.id.id_jam_log_transaksi);


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
        Picasso.get().load(dataModel.getUrlImage()).into(viewHolder.id_image_log);
        viewHolder.id_nama_transaksi.setText(dataModel.getNama_transkasi());
        viewHolder.id_tanggal_transaksi.setText("Tanggal Transaksi : " + dataModel.getTanggal_transaksi());
        viewHolder.id_jumlah_items.setText("Jumlah Transaksi : " + dataModel.getJumlah_transaksi());
        viewHolder.id_total_harga.setText("Total Harga : " + dataModel.getJumlah_Harga());
        viewHolder.id_jam_log_transaksi.setText("Jam Transaksi : " + dataModel.getJam_transaksi());


        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (Model_Log wp : originDataSet) {
                if (wp.getNama_transkasi().toLowerCase(Locale.getDefault())
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

