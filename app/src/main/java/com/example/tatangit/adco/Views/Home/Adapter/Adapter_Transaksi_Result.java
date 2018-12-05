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
import com.example.tatangit.adco.Views.Home.Model.Model_Transaksi_Result;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_Transaksi_Result extends ArrayAdapter<Model_Transaksi_Result> {

    private Context context;
    private List<Model_Transaksi_Result> dataSet = null;
    private ArrayList<Model_Transaksi_Result> originDataSet = null;
    LayoutInflater inflater;

    public Adapter_Transaksi_Result(ArrayList<Model_Transaksi_Result> data, Context context) {
        super(context, R.layout.activity_transaksi_result_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {
        ImageView id_img_result;
        CircleImageView id_img_harga;
        TextView id_header_Result;
        TextView id_jenis_bakso;
        TextView id_sisa_stock;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Model_Transaksi_Result getItem(int position) {
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
        final Model_Transaksi_Result dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_transaksi_result_row, parent, false);

            viewHolder.id_img_result = convertView.findViewById(R.id.id_img_result);
            viewHolder.id_img_harga = convertView.findViewById(R.id.id_img_harga);
            viewHolder.id_header_Result = convertView.findViewById(R.id.id_header_Result);
            viewHolder.id_jenis_bakso = convertView.findViewById(R.id.id_jenis_bakso);
            viewHolder.id_sisa_stock = convertView.findViewById(R.id.id_sisa_stock);




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
//        Picasso.get().load(dataModel.getUrlImage()).into(viewHolder.id_img_result);
//        Picasso.get().load(dataModel.getHarga()).into(viewHolder.id_img_harga);
        viewHolder.id_header_Result.setText(dataModel.getId_header_Result());
        viewHolder.id_jenis_bakso.setText("Jenis Rasa"+dataModel.getId_jenis_bakso());
        viewHolder.id_sisa_stock.setText("Stock Qty :"+dataModel.getId_sisa_stock());


        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (Model_Transaksi_Result wp : originDataSet) {
                if (wp.getId_header_Result().toLowerCase(Locale.getDefault())
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
