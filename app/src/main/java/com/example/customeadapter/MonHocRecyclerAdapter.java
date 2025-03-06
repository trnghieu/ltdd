package com.example.customeadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MonHocRecyclerAdapter extends RecyclerView.Adapter<MonHocRecyclerAdapter.ViewHolder> {
    private ArrayList<MonHoc> monHocList;

    public MonHocRecyclerAdapter(ArrayList<MonHoc> monHocList) {
        this.monHocList = monHocList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_monhoc_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonHoc monHoc = monHocList.get(position);
        holder.tvName.setText(monHoc.getName());
        holder.imgIcon.setImageResource(monHoc.getPic());
    }

    @Override
    public int getItemCount() {
        return monHocList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imgIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            imgIcon = itemView.findViewById(R.id.imgIcon);
        }
    }
}
