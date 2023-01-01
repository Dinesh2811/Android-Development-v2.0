package com.dinesh.android.java.dialog.rv.recycler_view.basic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinesh.android.R;

import java.util.ArrayList;
import java.util.List;

public class RvMain extends AppCompatActivity implements RvInterface {

    List<RvModel> rvModelList = new ArrayList<>();
    RvAdapter rvAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv1_main);
        recyclerView = findViewById(R.id.test_recyclerView);

//sample Model data
        for (int i = 0; i < 50; i++) {
            rvModelList.add(new RvModel("" + i, "Dinesh" + i, "dk" + i + "@gmail.com", "866" + i));
        }

        rvAdapter = new RvAdapter(rvModelList, RvMain.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(rvAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    //OnClickListner Using Interface
    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, NewLayout.class);
        intent.putExtra("ID", rvModelList.get(position).id);
        intent.putExtra("NAME", rvModelList.get(position).name);
        intent.putExtra("Email", rvModelList.get(position).name);
        intent.putExtra("Mobile", rvModelList.get(position).email);
        startActivity(intent);

    }
}
