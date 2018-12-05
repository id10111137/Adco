package com.example.tatangit.adco.Views.Home.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.adco.Views.Home.Model.Model_MyProduct;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import com.example.tatangit.adco.R;

public class Adapter_MyProduct extends ArrayAdapter<Model_MyProduct> {

    private Context context;
    private List<Model_MyProduct> dataSet = null;
    private ArrayList<Model_MyProduct> originDataSet = null;
    LayoutInflater inflater;

    public Adapter_MyProduct(ArrayList<Model_MyProduct> data, Context context) {
        super(context, R.layout.activity_homes_myproduct_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {
        ImageView id_image;
        TextView id_header;
        TextView id_name;
        TextView id_qty;
        TextView id_harga;
        TextView id_promo;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Model_MyProduct getItem(int position) {
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
        final Model_MyProduct dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_homes_myproduct_row, parent, false);

            viewHolder.id_image = convertView.findViewById(R.id.id_image);
            viewHolder.id_header = convertView.findViewById(R.id.id_header);
            viewHolder.id_name = convertView.findViewById(R.id.id_name);
            viewHolder.id_qty = convertView.findViewById(R.id.id_qty);
            viewHolder.id_harga = convertView.findViewById(R.id.id_harga);
            viewHolder.id_promo = convertView.findViewById(R.id.id_promo);



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
        Picasso.get().load(dataModel.getUrl_Image()).into(viewHolder.id_image);
        viewHolder.id_header.setText(dataModel.getTxt_header());
        viewHolder.id_name.setText("Name Product"+dataModel.getTxt_nama());
        viewHolder.id_qty.setText("Stock Qty :"+dataModel.getStock());
        viewHolder.id_harga.setText("Harga :"+dataModel.getHarga());
        viewHolder.id_promo.setText("Promo :"+dataModel.getPromo());

        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (Model_MyProduct wp : originDataSet) {
                if (wp.getTxt_header().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    dataSet.add(wp);
                }else {

                    Toast.makeText(context, "Data Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }
        }
        notifyDataSetChanged();
    }

}
