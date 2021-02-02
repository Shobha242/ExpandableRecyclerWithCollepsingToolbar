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

public class ExpandableAdapter extends RecyclerView.Adapter<ExpandableAdapter.MyViewHolder> {

    ArrayList<ExpandableListModel> arrayList;
    ArrayList<ExpandableListModel> childList = new ArrayList<>();
    Context context;
    boolean isExpandable;


    public ExpandableAdapter(ArrayList<ExpandableListModel> arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_expandable_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpandableAdapter.MyViewHolder holder, int position) {

        holder.customerProductNo.setText(arrayList.get(position).getProductNumber());


        isExpandable = arrayList.get(position).isExpandable();
        Log.d("isExpandable__", String.valueOf(isExpandable));
        if (isExpandable) {

            holder.rv_child.setVisibility(View.VISIBLE);
            ExpandableChildAdapter adapter = new ExpandableChildAdapter(childList, context);
            holder.rv_child.setAdapter(adapter);
            expandableParentList();
        } else {
            holder.rv_child.setVisibility(View.GONE);
        }

    }

    public void expandableParentList() {
        childList.clear();
        for (int i = 0; i < 5; i++) {
            ExpandableListModel model = new ExpandableListModel();
            model.setProductNumber("4759347534895");
            model.setMobile("34095834095");
            model.setSku("34958304985");
            childList.add(model);
        }
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
            customerProductNo = itemView.findViewById(R.id.customerProductNo);
            rv_child = itemView.findViewById(R.id.rv_child);

            parent_LL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("isExpandab__", String.valueOf(isExpandable));
                    ExpandableListModel model = arrayList.get(getAdapterPosition());
                    model.setExpandable(!model.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
