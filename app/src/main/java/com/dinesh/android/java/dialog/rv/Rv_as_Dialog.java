package com.dinesh.android.java.dialog.rv;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.android.R;
import com.dinesh.android.java.dialog.rv.recycler_view.basic.RvAdapter;
import com.dinesh.android.java.dialog.rv.recycler_view.basic.RvInterface;
import com.dinesh.android.java.dialog.rv.recycler_view.basic.RvModel;

import java.util.ArrayList;
import java.util.List;

public class Rv_as_Dialog extends AppCompatActivity implements RvInterface {
    private final String TAG = "log_" + this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".")
            [this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".").length - 1];

    List<RvModel> rvModelList = new ArrayList<>();
    RvAdapter rvAdapter;
    RecyclerView recyclerView;
    TextView textView;
    public Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.ActivityMain_TextView);

        dialog = new Dialog(Rv_as_Dialog.this);
        dialog.setContentView(R.layout.rv_main);
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);

        recyclerView = dialog.findViewById(R.id.test_recyclerView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: textView " );
                dialog.show();
            }
        });

        for (int i = 0; i < 50; i++) {
            rvModelList.add(new RvModel("" + i, "Dinesh" + i, "dk" + i + "@gmail.com", "866" + i));
        }

        rvAdapter = new RvAdapter(rvModelList, Rv_as_Dialog.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(rvAdapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.e(TAG, "onItemClick: "+rvModelList.get(position) );
    }
}
