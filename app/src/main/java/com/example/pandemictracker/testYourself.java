package com.example.pandemictracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class testYourself extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_yourself);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"National Helpline Number","1075"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Central Helpline Number","+91-11-23978043"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"MyGov WhatsApp\n Number","+91-90131-51515"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Central Helpline Email","ncov2019@gmail.com"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Andhra Pradesh","0866-2410978"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Arunachal Pardesh","6913347770"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Bihar","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Chhattisgarh","077122-35091"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Goa","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Gujarat","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Harayana","8558893911"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Himachal pradesh","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Jharkhand","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Karnataka","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Kerala","0471-2552056"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Madhya Pradesh","0755-2527177"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Maharashtra","020-26127394"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Manipur","3852411668"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Meghalaya","108"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Mizoram","102"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Nagaland","7005539653"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Odisha","9439994859"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Punjab","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Rajasthan","0141-2225624"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Sikkim","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Tamil Nadu","044-29510500"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Telangana","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Tripura","0381-2315879"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Uttarakhand","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Uttar Pradesh","18001805145"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"West Bengal","18000313444222"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Andaman and Nicobar\n Islands","03192-232102"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Chandigarh","9779558282"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Dadar and Nagar Haveli &\n Daman and Diu","104"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Delhi","011-22307145"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Jammu & Kashmir","1912520982"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Ladakh","1982256462"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Lakshadweep","4896263742"));
        exampleList.add(new ExampleItem(R.drawable.ic_call_black_24dp,"Puducherry","104"));

        mRecyclerView = findViewById(R.id.recyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }
}
