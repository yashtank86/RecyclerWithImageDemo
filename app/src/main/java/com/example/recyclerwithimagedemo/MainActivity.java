package com.example.recyclerwithimagedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<String> imagearray = new ArrayList<>();


    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        addData();
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter(imagearray, this);
        recyclerView.setAdapter(recyclerAdapter);

    }

    public void addData() {

        imagearray.add("https://images.pexels.com/photos/1149831/pexels-photo-1149831.jpeg");
        imagearray.add("https://images.pexels.com/photos/337909/pexels-photo-337909.jpeg");
        imagearray.add("https://images.pexels.com/photos/799443/pexels-photo-799443.jpeg");
        imagearray.add("https://images.pexels.com/photos/116675/pexels-photo-116675.jpeg");
        imagearray.add("https://images.pexels.com/photos/981041/pexels-photo-981041.jpeg");
        imagearray.add("https://images.pexels.com/photos/276514/pexels-photo-276514.jpeg");
        imagearray.add("https://images.pexels.com/photos/1485894/pexels-photo-1485894.jpeg");
        imagearray.add("https://images.pexels.com/photos/414144/pexels-photo-414144.jpeg");
        imagearray.add("https://images.pexels.com/photos/1363876/pexels-photo-1363876.jpeg");
        imagearray.add("https://images.pexels.com/photos/1236701/pexels-photo-1236701.jpeg");
        imagearray.add("https://images.pexels.com/photos/346529/pexels-photo-346529.jpeg");
        imagearray.add("https://images.pexels.com/photos/39811/pexels-photo-39811.jpeg");
        imagearray.add("https://images.pexels.com/photos/102127/pexels-photo-102127.jpeg");
        imagearray.add("https://images.pexels.com/photos/1053687/pexels-photo-1053687.jpeg");
        imagearray.add("https://images.pexels.com/photos/1918290/pexels-photo-1918290.jpeg");
        imagearray.add("https://images.pexels.com/photos/241316/pexels-photo-241316.jpeg");
        imagearray.add("https://images.pexels.com/photos/909907/pexels-photo-909907.jpeg");
        imagearray.add("https://images.pexels.com/photos/981041/pexels-photo-981041.jpeg");
        imagearray.add("https://images.pexels.com/photos/210019/pexels-photo-210019.jpeg");
        imagearray.add("https://images.pexels.com/photos/136872/pexels-photo-136872.jpeg");
        imagearray.add("https://images.pexels.com/photos/977003/pexels-photo-977003.jpeg");
        imagearray.add("https://images.pexels.com/photos/1168940/pexels-photo-1168940.jpeg");
        imagearray.add("https://images.pexels.com/photos/682484/pexels-photo-682484.jpeg");
        imagearray.add("https://images.pexels.com/photos/1694102/pexels-photo-1694102.jpeg");

    }
}
      
            
