package com.example.expandablerecyclerview.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expandablerecyclerview.R;
import com.example.expandablerecyclerview.models.ExpandableListModel;

import java.util.ArrayList;

public class ExpandableChildAdapter extends RecyclerView.Adapter<ExpandableChildAdapter.MyViewHolder> {

    ArrayList<ExpandableListModel> arrayList;
    Context context;


    public ExpandableChildAdapter(ArrayList<ExpandableListModel> arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_expandable_child_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("ExpandableChil_", String.valueOf(arrayList.size()));
        holder.customerProductnameMobno.setText(arrayList.get(position).getMobile());
        holder.customerProductmodelno.setText(arrayList.get(position).getSku());

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout myPrditemClicked;
        EditText ET_Modelnumber;
        TextView tv_lavel, ET_ModelnumberHint;

        TextView customerProductNo, customerProductDate, customerProductName, customerProductnameMobno, customerProductmodelno, customerProductDealerAddress;

        LinearLayout myproductfilterL1, myProductBelowLay, parent_LL;
        ImageView customerProductImage;
        TextView instaRq, delete;
        RelativeLayout viewMyprod1;
        RecyclerView rv_child;
        RecyclerView MyProductFilterAdapter_value;
        LinearLayout LL_MyProductFilterAdapter_value;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            parent_LL = itemView.findViewById(R.id.parent_LL);
            myPrditemClicked = itemView.findViewById(R.id.myPrditemClicked);
            customerProductImage = itemView.findViewById(R.id.customerProductImage);
            customerProductNo = itemView.findViewById(R.id.customerProductNo);
            customerProductName = itemView.findViewById(R.id.customerProductName);
            customerProductnameMobno = itemView.findViewById(R.id.customerProductnameMobno);
            customerProductmodelno = itemView.findViewById(R.id.customerProductmodelno);
            customerProductDealerAddress = itemView.findViewById(R.id.customerProductDealerAddress);
            MyProductFilterAdapter_value = itemView.findViewById(R.id.MyProductFilterAdapter_value);
            delete = itemView.findViewById(R.id.delete);
            instaRq = itemView.findViewById(R.id.instaRq);
            viewMyprod1 = itemView.findViewById(R.id.viewMyprod1);
            myProductBelowLay = itemView.findViewById(R.id.myProductBelowLay);
            LL_MyProductFilterAdapter_value = itemView.findViewById(R.id.LL_MyProductFilterAdapter_value);

        }
    }
}
