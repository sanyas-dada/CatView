package com.sanyasdada.catview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbarCollapsing;
    RecyclerView demoRecyclerView;

    ImageAdapter imageAdapter;
    List<ImageModel> imageModeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbarCollapsing = findViewById(R.id.toolbar_collapsing);
        setSupportActionBar(toolbarCollapsing);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (toolbarCollapsing != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbarCollapsing.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });

        }


       /* demoRecyclerView = findViewById(R.id.recycler_view);
        imageAdapter = new ImageAdapter(this.getImageModeList(),this);
        demoRecyclerView.setAdapter(imageAdapter);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.cart:
                startActivity(new Intent(this,ChallengingProblem.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public List<ImageModel> getImageModeList(){
        List<ImageModel>imageModellist1 = new ArrayList<>();
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));
        imageModellist1.add(new ImageModel(R.drawable.xiaomi,"Xiamoi","Rs.40000"));

        return imageModellist1;

    }


}