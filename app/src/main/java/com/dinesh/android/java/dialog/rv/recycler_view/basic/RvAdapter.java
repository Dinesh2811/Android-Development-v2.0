package com.dinesh.android.java.dialog.rv.recycler_view.basic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.android.R;

import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    private final String TAG = "log_" + this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".")
            [this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".").length - 1];

    List<RvModel> rvModelList = new ArrayList<>();
    RvInterface rvInterface;

    public RvAdapter(List<RvModel> rvModelList, RvInterface rvInterface) {
        this.rvModelList = rvModelList;
        this.rvInterface = rvInterface;
    }

    public RvAdapter(List<RvModel> rvModelList) {
        this.rvModelList = rvModelList;
    }

    public RvAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(rvModelList.get(position).id);
        holder.textView2.setText(rvModelList.get(position).name);
        holder.textView3.setText(rvModelList.get(position).email);
        holder.textView4.setText(rvModelList.get(position).mobile);
    }

    @Override
    public int getItemCount() {
        return rvModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView2, textView3, textView4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.test_textView1);
            textView2 = itemView.findViewById(R.id.test_textView2);
            textView3 = itemView.findViewById(R.id.test_textView3);
            textView4 = itemView.findViewById(R.id.test_textView4);

//itemView doesn't work if layout has scroll view or card view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Calling Interface method & Passing Values
                    rvInterface.onItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
