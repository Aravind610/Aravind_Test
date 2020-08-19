package com.aravind.aravind_systemtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aravind.aravind_systemtest.pojos.screen1_pojo;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tvprice;
    String stprice,addeditems;
    private List<screen1_pojo> itemList;
    private screen1_adapter adapter;

    private RecyclerView recyclerView;
    String stopen1 = null;
    String stopen2 = null;
    String stopen3 = null;
    int cartcount = 0;
    String stcartcount;
    private int firstitemcount;
    private int seconditemcount;
    private int thirditemcount ;
    int finalcount1,finalcount2,finalcount3;
    TextView tv_showmore;
    String st;
    String count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            stprice = bundle.getString("totalprice");
            addeditems = bundle.getString("addeditem");
            firstitemcount = bundle.getInt("firstitemcount");
            seconditemcount = bundle.getInt("seconditem");
            thirditemcount = bundle.getInt("thirditem");
            stcartcount = bundle.getString("cartcount");
        }

        initlizeviews();
        initlizerecyclerview();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Toast.makeText(this, st, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("firstitemcount",firstitemcount);
        intent.putExtra("seconditem",seconditemcount);
        intent.putExtra("thirditem",thirditemcount);
        intent.putExtra("cartcount",st);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setViewData() {

        itemList.clear();

        if (addeditems.equals("0nullnull")){

            itemList.add(new screen1_pojo(1, "Guac de la Costa", "tortillas de mais, fruit de la passion, mango","70"));
        }else if (addeditems.equals("012")){

            itemList.add(new screen1_pojo(1, "Guac de la Costa", "tortillas de mais, fruit de la passion, mango","70"));
            itemList.add(new screen1_pojo(2, "Chicharron y Cerveza", "citron vert / Corona sauce","50"));
            itemList.add(new screen1_pojo(3, "Chilitos con", "padrones tempura, gambas","80"));
         //   tv_showmore.setVisibility(View.VISIBLE);

        }else if (addeditems.equals("0null2")){


            itemList.add(new screen1_pojo(1, "Guac de la Costa", "tortillas de mais, fruit de la passion, mango","70"));
            itemList.add(new screen1_pojo(3, "Chilitos con", "padrones tempura, gambas","80"));

        }else if (addeditems.equals("null12")){
//

            itemList.add(new screen1_pojo(2, "Chicharron y Cerveza", "citron vert / Corona sauce","50"));
            itemList.add(new screen1_pojo(3, "Chilitos con", "padrones tempura, gambas","80"));

        }else if (addeditems.equals("01null")){

            itemList.add(new screen1_pojo(1, "Guac de la Costa", "tortillas de mais, fruit de la passion, mango","70"));
            itemList.add(new screen1_pojo(2, "Chicharron y Cerveza", "citron vert / Corona sauce","50"));

        }

        else if (addeditems.equals("02")){

            itemList.add(new screen1_pojo(1, "Guac de la Costa", "tortillas de mais, fruit de la passion, mango","70"));
            itemList.add(new screen1_pojo(3, "Chilitos con", "padrones tempura, gambas","80"));

        }else if (addeditems.equals("12")){

            itemList.add(new screen1_pojo(2, "Chicharron y Cerveza", "citron vert / Corona sauce","50"));
            itemList.add(new screen1_pojo(3, "Chilitos con", "padrones tempura, gambas","80"));

        }else if (addeditems.equals("01")){

            itemList.add(new screen1_pojo(1, "Guac de la Costa", "tortillas de mais, fruit de la passion, mango","70"));
            itemList.add(new screen1_pojo(2, "Chicharron y Cerveza", "citron vert / Corona sauce","50"));

        }
        if (addeditems.equals("null1null")){

            itemList.add(new screen1_pojo(2, "Chicharron y Cerveza", "citron vert / Corona sauce","50"));
        }
        if (addeditems.equals("nullnull2")){

            itemList.add(new screen1_pojo(3, "Chilitos con", "padrones tempura, gambas","80"));
        }
        adapter = new screen1_adapter(itemList);
        recyclerView.setAdapter(adapter);

      //  adapter.notifyDataSetChanged();
    }

    public void finalcounting1(){

        finalcount1 = firstitemcount*Integer.parseInt(stprice);
        tvprice.setText(stprice);

    }
    public void finalcounting2(){

        finalcount2 = seconditemcount*Integer.parseInt(stprice);
        tvprice.setText(stprice);

    }

    public void finalcounting3(){

        finalcount3 = thirditemcount*Integer.parseInt(stprice);
        tvprice.setText(stprice);

    }

    public void initlizerecyclerview(){
        recyclerView = findViewById(R.id.rv_list);

        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        itemList = new ArrayList<>();


        setViewData();
    }

    public void initlizeviews(){
        tvprice = findViewById(R.id.tv_totalprice);

        tvprice.setText(stprice);

        tv_showmore = findViewById(R.id.tv_showmore);
        tv_showmore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_showmore:
                openshowmore();
                return;
        }
    }

    public void openshowmore(){
        adapter = new screen1_adapter(itemList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public class screen1_adapter extends RecyclerView.Adapter<Main2Activity.screen1_adapter.SubCategoryViewHolder> {

        private Context context;
        private List<screen1_pojo> arrayList;

        public screen1_adapter(List<screen1_pojo> arrayList) {
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public Main2Activity.screen1_adapter.SubCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            context = parent.getContext();
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.screen1_listdesign, parent, false);
            return new Main2Activity.screen1_adapter.SubCategoryViewHolder(view);
        }

        @SuppressLint("ResourceType")
        @Override
        public void onBindViewHolder(@NonNull final Main2Activity.screen1_adapter.SubCategoryViewHolder holder, final int position) {
            screen1_pojo item = arrayList.get(position);

            holder.tvtext1.setText(item.getScreen_text1());
            holder.tvtext2.setText(item.getScreen_text2());
            holder.tvprice.setText(item.getPrice());

            if (position == 0) {
                String s = String.valueOf(firstitemcount);

                holder.tvcount.setText(s);
            }if (position == 1){
                String s = String.valueOf(seconditemcount);

                holder.tvcount.setText(s);
            }if (position == 2){
                String s = String.valueOf(thirditemcount);

                holder.tvcount.setText(s);
            }

            if (position == 0){
                holder.ivplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        firstitemcount = firstitemcount + 1;
                        int s = Integer.parseInt(stcartcount);
                        int da = s+1;
                        st = String.valueOf(da);
                        // st = String.valueOf(s+1);
                         count = String.valueOf(firstitemcount);
                        holder.tvcount.setText(count);
                        finalcounting1();
                        stopen1 = "0";
                        if (firstitemcount == 20){
                            holder.ivplus.setEnabled(false);
                            Toast.makeText(context, "You can select only 20 items", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }if (position == 1){
                holder.ivplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        seconditemcount = seconditemcount + 1;
                        int s = Integer.parseInt(stcartcount);
                        st = String.valueOf(s+1);
                         count = String.valueOf(seconditemcount);
                        holder.tvcount.setText(count);
                        finalcounting2();
                        stopen2 = "1";
                        if (seconditemcount == 20){
                            holder.ivplus.setEnabled(false);
                            Toast.makeText(context, "You can select only 20 items", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }if (position == 2){
                holder.ivplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        thirditemcount = thirditemcount + 1;
                        int s = Integer.parseInt(stcartcount);
                        st = String.valueOf(s+1);
                         count = String.valueOf(thirditemcount);
                        holder.tvcount.setText(count);
                        finalcounting3();
                        stopen3 = "2";
                        if (thirditemcount == 20){
                            holder.ivplus.setEnabled(false);
                            Toast.makeText(context, "You can select only 20 items", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            if (position == 0){
                holder.ivminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        firstitemcount = firstitemcount - 1;
                        int s = Integer.parseInt(stcartcount);
                        st = String.valueOf(s-1);
                        Toast.makeText(context, st, Toast.LENGTH_SHORT).show();
                         count = String.valueOf(firstitemcount);
                        holder.tvcount.setText(count);
                        finalcounting1();
                        if (firstitemcount == 0){
                            holder.ivminus.setEnabled(false);
                        }

                    }
                });
            }if (position == 1){
                holder.ivminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        seconditemcount = seconditemcount - 1;
                        int s = Integer.parseInt(stcartcount);
                        st = String.valueOf(s-1);
                         count = String.valueOf(seconditemcount);
                        holder.tvcount.setText(count);
                        finalcounting2();
                        if (seconditemcount == 0){
                            holder.ivminus.setEnabled(false);
                        }
                    }
                });

            }if (position == 2){
                holder.ivminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        thirditemcount = thirditemcount - 1;
                        int s = Integer.parseInt(stcartcount);
                        st = String.valueOf(s-1);
                         count = String.valueOf(thirditemcount);
                        holder.tvcount.setText(count);
                        finalcounting3();
                        if (thirditemcount == 0){
                            holder.ivminus.setEnabled(false);
                        }
                    }
                });

            }



        }
        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        class SubCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView tvtext1, tvtext2, tvcount,tvprice,tvshowmore;
            ImageView ivplus, ivminus;

            SubCategoryViewHolder(View itemView) {
                super(itemView);

                tvtext1 = itemView.findViewById(R.id.design_text1);
                tvtext2 = itemView.findViewById(R.id.design_text2);
                tvcount = itemView.findViewById(R.id.items_count);
                tvprice = itemView.findViewById(R.id.tvscreen1_item_price);
                ivplus = itemView.findViewById(R.id.plus);
                ivminus = itemView.findViewById(R.id.minus);


                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

            }

        }

    }
}
