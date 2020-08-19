package com.aravind.aravind_systemtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aravind.aravind_systemtest.R;
import com.aravind.aravind_systemtest.pojos.screen1_pojo;

import java.util.List;

public class screen1_adapter extends RecyclerView.Adapter<screen1_adapter.SubCategoryViewHolder>{

    private Context context;
    private List<screen1_pojo> arrayList;
    private int clickcount = 0;

    public screen1_adapter(List<screen1_pojo> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public screen1_adapter.SubCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.screen1_listdesign, parent, false);
        return new screen1_adapter.SubCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final screen1_adapter.SubCategoryViewHolder holder, final int position) {
        final screen1_pojo item = arrayList.get(position);

        if (arrayList.size() == 2){

        }

        holder.tvtext1.setText(item.getScreen_text1());
        holder.tvtext2.setText(item.getScreen_text2());
        holder.tvprice.setText(item.getPrice());
        holder.tvcount.setText(item.getCount());

        holder.ivplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickcount=clickcount+1;
               // Toast.makeText(context,"Button clicked count is"+clickcount, Toast.LENGTH_LONG).show();
                //   tvcount.setText(clickcount);
                addplus(holder.tvcount);

            }
        });

        holder.ivminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickcount=clickcount-1;

                holder.tvcount.setText(clickcount);

              //  Toast.makeText(context,"Button clicked count is"+clickcount, Toast.LENGTH_LONG).show();



            }
        });

    }
    public void addplus(TextView tvcount){
        tvcount.setText(clickcount);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class SubCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvtext1,tvtext2,tvcount,tvprice;
        ImageView ivplus,ivminus;

        SubCategoryViewHolder(View itemView) {
            super(itemView);

            tvtext1 = itemView.findViewById(R.id.design_text1);
            tvtext2 = itemView.findViewById(R.id.design_text2);
            tvcount = itemView.findViewById(R.id.items_count);
            tvprice = itemView.findViewById(R.id.tvscreen1_item_price);
            ivplus = itemView.findViewById(R.id.plus);
            ivminus = itemView.findViewById(R.id.minus);

            ivplus.setOnClickListener(this);
            ivminus.setOnClickListener(this);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }

    }
}