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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aravind.aravind_systemtest.adapter.screen1_adapter;
import com.aravind.aravind_systemtest.pojos.screen1_pojo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<screen1_pojo> itemList;
    private screen1_adapter adapter;

    private RecyclerView recyclerView;
    LinearLayout linearLayout;
    TextView tvviewcart;
    String stopen1 = null;
    String stopen2 = null;
    String stopen3 = null;

    int cartcount = 0;
    String stcartcount;
    int st = 0;
    private int firstitemcount ;
    private int seconditemcount ;
    private int thirditemcount ;
    int finalcount1,finalcount2,finalcount3;
    String finalprice1,finalprice2,finalprice3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null) {
            firstitemcount = bundle.getInt("firstitemcount");
            seconditemcount = bundle.getInt("seconditem");
            thirditemcount = bundle.getInt("thirditem");
            stcartcount = bundle.getString("cartcount");
        }

       // cartcount = Integer.parseInt(st);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(null);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);

        }

        linearLayout = findViewById(R.id.ll_viewcart);
        linearLayout.setOnClickListener(this);
        tvviewcart = findViewById(R.id.tv_viewcart);
        tvviewcart.setText("View Cart ("+stcartcount+") Items");

        initializeRecyclerView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void initializeRecyclerView() {
        recyclerView = findViewById(R.id.rv_list);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        itemList = new ArrayList<>();

        adapter = new screen1_adapter(itemList);
        recyclerView.setAdapter(adapter);

        setViewData();
        finalcounting1();

    }

    public void finalcounting1(){

        finalcount1 = firstitemcount*70;


    }
    public void finalcounting2(){

        finalcount2 = seconditemcount*50;

    }

    public void finalcounting3(){

        finalcount3 = thirditemcount*80;

    }

    public void setViewData() {

        itemList.clear();

        itemList.add(new screen1_pojo(1, "Guac de la Costa", "tortillas de mais, fruit de la passion, mango","70"));
        itemList.add(new screen1_pojo(2, "Chicharron y Cerveza", "citron vert / Corona sauce","50"));
        itemList.add(new screen1_pojo(3, "Chilitos con", "padrones tempura, gambas","80"));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.ll_viewcart:
                opencart();
                return;
        }

    }

    public void opencart(){
        int coun = finalcount1+finalcount2+finalcount3;
        String s = String.valueOf(coun);

        String st = stopen1+stopen2+stopen3;
        Toast.makeText(this, st, Toast.LENGTH_SHORT).show();

            if (st.equals("nullnullnull")){
                Toast.makeText(this, "Please Select Item", Toast.LENGTH_SHORT).show();

            }else {
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("totalprice", s);
                intent.putExtra("addeditem", st);
                intent.putExtra("firstitemcount", firstitemcount);
                intent.putExtra("seconditem", seconditemcount);
                intent.putExtra("thirditem", thirditemcount);
                intent.putExtra("cartcount", stcartcount);
                startActivity(intent);
            }

    }
    public class screen1_adapter extends RecyclerView.Adapter<screen1_adapter.SubCategoryViewHolder> {

        private Context context;
        private List<screen1_pojo> arrayList;

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

        @SuppressLint("ResourceType")
        @Override
        public void onBindViewHolder(@NonNull final screen1_adapter.SubCategoryViewHolder holder, final int position) {
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
                        cartcount = cartcount +1;
                     //   cartcount = cartcount + Integer.parseInt(stcartcount);
                        stcartcount = String.valueOf(cartcount);
                        int in = Integer.parseInt(stcartcount);
                      //  int ss = Integer.parseInt(st);

                        int fina = in+st;
                        String  stf = String.valueOf(fina);
                          String count = String.valueOf(firstitemcount);
                          holder.tvcount.setText(count);
                        tvviewcart.setText("View Cart ("+stf+") Items");

                        finalcounting1();
                        stopen1 = "0";
                        if (firstitemcount == 20){
                            holder.ivplus.setEnabled(false);
                            Toast.makeText(context, "You can select only 20 items", Toast.LENGTH_SHORT).show();
                        }

                        // opennextpage("0");

                    }
                });
            }if (position == 1){
                holder.ivplus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        seconditemcount = seconditemcount + 1;
                        cartcount = cartcount +1;
                        stcartcount = String.valueOf(cartcount);
                        int sss = st;
                        String count = String.valueOf(seconditemcount);
                        holder.tvcount.setText(count);
                        tvviewcart.setText("View Cart ("+stcartcount+") Items");
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
                        cartcount = cartcount +1;
                        cartcount = cartcount+st;
                        stcartcount = String.valueOf(cartcount);
                        String count = String.valueOf(thirditemcount);
                        holder.tvcount.setText(count);
                        tvviewcart.setText("View Cart ("+stcartcount+") Items");
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
                        cartcount = cartcount -1;
                        stcartcount = String.valueOf(cartcount);
                        String count = String.valueOf(firstitemcount);
                        holder.tvcount.setText(count);
                        tvviewcart.setText("View Cart ("+stcartcount+") Items");
                        finalcounting1();
                        stopen1 = "";
                        if (firstitemcount == 0 || firstitemcount == -1){
                            holder.ivminus.setEnabled(false);
                        }
                        if (stcartcount.equals("0") || stcartcount .equals("-1")){
                            holder.ivminus.setEnabled(false);
                        }

                    }
                });
            }if (position == 1){
                holder.ivminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        seconditemcount = seconditemcount - 1;
                        cartcount = cartcount -1;
                        stcartcount = String.valueOf(cartcount);
                        String count = String.valueOf(seconditemcount);
                        holder.tvcount.setText(count);
                        tvviewcart.setText("View Cart ("+stcartcount+") Items");
                        finalcounting2();
                        stopen2 = "";
                        if (seconditemcount == 0 || seconditemcount == -1){
                            holder.ivminus.setEnabled(false);
                        }
                        if (stcartcount.equals("0") || stcartcount .equals("-1")){
                            holder.ivminus.setEnabled(false);
                        }
                    }
                });

            }if (position == 2) {
                holder.ivminus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        thirditemcount = thirditemcount - 1;
                        cartcount = cartcount -1;
                        stcartcount = String.valueOf(cartcount);
                        String count = String.valueOf(thirditemcount);
                        holder.tvcount.setText(count);
                        tvviewcart.setText("View Cart ("+stcartcount+") Items");
                        finalcounting3();
                        stopen3 = "";
                        if (thirditemcount == 0 || thirditemcount == -1) {
                            holder.ivminus.setEnabled(false);
                        }
                        if (stcartcount.equals("0") || stcartcount .equals("-1")) {
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

            TextView tvtext1, tvtext2, tvcount, tvprice;
            ImageView ivplus, ivminus;

            SubCategoryViewHolder(View itemView) {
                super(itemView);

                tvtext1 = itemView.findViewById(R.id.design_text1);
                tvtext2 = itemView.findViewById(R.id.design_text2);
                tvcount = itemView.findViewById(R.id.items_count);
                tvprice = itemView.findViewById(R.id.tvscreen1_item_price);
                ivplus = itemView.findViewById(R.id.plus);
                ivminus = itemView.findViewById(R.id.minus);
                ivminus.setOnClickListener(this);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {

            }

        }

    }
}
