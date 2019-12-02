package com.example.duniadinosaurus;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListDinoAdapter extends RecyclerView.Adapter<ListDinoAdapter.ListViewHolder> {

    private ArrayList<Dino> listDino;

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    public ListDinoAdapter(ArrayList<Dino> list){
        this.listDino = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_dino, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

        final Dino dino= listDino.get(position);
        Glide.with(holder.itemView.getContext())
                .load(dino.getImage())
                .apply(new RequestOptions().override(100, 120))
                .into(holder.imgDino);
        holder.tvName.setText(dino.getName());
        holder.tvDetail.setText(dino.getDetail());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listDino.get(holder.getAdapterPosition()));

                Intent intent= new Intent(v.getContext(),DetailDino.class);
                intent.putExtra("dino_image",dino.getImage());
                intent.putExtra("dino_name",dino.getName());
                intent.putExtra("dino_deskripsi",dino.getDetail());

                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listDino.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDino;
        TextView tvName,tvDetail;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDino = itemView.findViewById(R.id.img_dino);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }


    public interface OnItemClickCallback {
        void onItemClicked(Dino data);
    }

}
