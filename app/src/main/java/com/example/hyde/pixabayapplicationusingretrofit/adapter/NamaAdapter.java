package com.example.hyde.pixabayapplicationusingretrofit.adapter;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hyde.pixabayapplicationusingretrofit.R;
import com.example.hyde.pixabayapplicationusingretrofit.activity.Recyc;
import com.example.hyde.pixabayapplicationusingretrofit.models.HitsItem;

import java.util.List;

public class NamaAdapter extends RecyclerView.Adapter<NamaAdapter.MyHolder> {
    private List<com.example.hyde.pixabayapplicationusingretrofit.models.HitsItem> myData;
    private Recyc activity;


    public NamaAdapter(Recyc mainActivity, List<HitsItem> hits) {
        this.myData = hits;
        this.activity = mainActivity;
    }


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nama, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        // Menampilkan String
        holder.like.setText("by " + myData.get(position).user);

        // Menampilkan gambar
        Glide.with(activity).load(myData.get(position).webformatURL)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onItemClick(myData.get(position));

                /*AlertDialog.Builder ad = new AlertDialog.Builder(activity);
                LayoutInflater inflater = activity.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.popup_window, null);

                ImageView image = (ImageView) dialogView.findViewById(R.id.tv);


                Glide.with(activity).load(myData.get(position).webformatURL)
                        .into(image);
                ad.setView(dialogView);
AlertDialog alertDialog=ad.create();
alertDialog.show();
                *
                * */
            }
        });

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView like;
        ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            like = (TextView) itemView.findViewById(R.id.texs1);
            imageView = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
