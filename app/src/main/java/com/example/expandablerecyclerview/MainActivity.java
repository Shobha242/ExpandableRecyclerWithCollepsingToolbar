package com.example.expandablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.expandablerecyclerview.adapters.ExpandableAdapter;
import com.example.expandablerecyclerview.models.ExpandableChildListModel;
import com.example.expandablerecyclerview.models.ExpandableListModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        setSupportActionBar(mToolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        rv_expandable = findViewById(R.id.rv_expandable);

        ExpandablrUrl();
    }

    public void expandableParentList() {
//        arrayList.clear();
//        for (int i = 0; i < 10; i++) {
//            ExpandableListModel model = new ExpandableListModel();
//            model.setProductNumber("4759347534895");
//            model.setMobile("34095834095");
//            model.setSku("34958304985");
//            arrayList.add(model);
//        }
        expandableAdapter = new ExpandableAdapter(arrayList, getApplicationContext());
        rv_expandable.setAdapter(expandableAdapter);
    }

    public void ExpandablrUrl() {
        String url = "{ \"data\": { \"dealer_products_filter\": { \"responseInfo\": { \"status\": 200, \"message\": \"\", \"error\": \"\" }, \"filtered_order\": [ { \"id\": 1301874, \"no\": \"PRD6017D3C05B014\", \"detail\": { \"history_summary\": [ { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 } ] } }, { \"id\": 1301874, \"no\": \"PRD6017D3C05B014\", \"detail\": { \"history_summary\": [ { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 } ] } }, { \"id\": 1301874, \"no\": \"PRD6017D3C05B014\", \"detail\": { \"history_summary\": [ { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 } ] } }, { \"id\": 1301874, \"no\": \"PRD6017D3C05B014\", \"detail\": { \"history_summary\": [ { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 } ] } }, { \"id\": 1301874, \"no\": \"PRD6017D3C05B014\", \"detail\": { \"history_summary\": [ { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 }, { \"name\": \"Warranty Left in days\", \"count\": 337 } ] } } ] } } }";
        try {
            JSONObject jsonObject = new JSONObject(url);
            JSONObject dataobj = jsonObject.optJSONObject("data");
            JSONObject dealer_products_filterObj = dataobj.optJSONObject("dealer_products_filter");
            JSONArray dealer_products_filterArray = dealer_products_filterObj.optJSONArray("filtered_order");
            for (int i = 0; i < dealer_products_filterArray.length(); i++) {
                JSONObject filterArrayObj = dealer_products_filterArray.optJSONObject(i);
                ExpandableListModel parentModel = new ExpandableListModel();
                parentModel.setProductNumber(filterArrayObj.optString("no"));
                JSONObject detailObj = filterArrayObj.optJSONObject("detail");
                ArrayList<ExpandableChildListModel> childList = new ArrayList<>();
                JSONArray history_summaryArray = detailObj.optJSONArray("history_summary");
                for (int j = 0; j < history_summaryArray.length(); j++) {
                    JSONObject historySummaryobj = history_summaryArray.optJSONObject(j);
                    ExpandableChildListModel subListmodel = new ExpandableChildListModel();
                    subListmodel.setSku(historySummaryobj.optString("count"));

                    subListmodel.setMobile(historySummaryobj.optString("name"));
                    Log.d("mobileeeeee__", historySummaryobj.optString("count"));
                    childList.add(subListmodel);
                    parentModel.setChildList(childList);

                }
                Log.d("childlistsize", String.valueOf(childList.size()));

                parentModel.setChildList(childList);

                arrayList.add(parentModel);
                expandableParentList();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}