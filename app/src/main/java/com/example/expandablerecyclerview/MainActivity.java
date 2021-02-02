package com.example.expandablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.expandablerecyclerview.adapters.ExpandableAdapter;
import com.example.expandablerecyclerview.models.ExpandableListModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_expandable;
    ArrayList<ExpandableListModel> arrayList = new ArrayList<>();
    ExpandableAdapter expandableAdapter;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        rv_expandable = findViewById(R.id.rv_expandable);
        expandableAdapter = new ExpandableAdapter(arrayList, getApplicationContext());
        rv_expandable.setAdapter(expandableAdapter);
        expandableParentList();
    }

    public void expandableParentList() {
        arrayList.clear();
        for (int i = 0; i < 10; i++) {
            ExpandableListModel model = new ExpandableListModel();
            model.setProductNumber("4759347534895");
            model.setMobile("34095834095");
            model.setSku("34958304985");
            arrayList.add(model);
        }
    }
}