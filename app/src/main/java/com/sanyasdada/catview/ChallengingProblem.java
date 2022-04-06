package com.sanyasdada.catview;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.sanyasdada.catview.listener.ShowInterface;

import java.util.ArrayList;
import java.util.List;

public class ChallengingProblem extends AppCompatActivity implements ShowInterface {
    private final static String TAG = ChallengingProblem.class.getSimpleName();
    RecyclerView recyclerView;
    productAdapter productAdapter;
    List<String> listOFString;

    TextView ratingAndReviews;
    TextView productDetails;
    NestedScrollView nestedScrollView;
    LinearLayout layout;
    ImageSwitcher imageSwitcher;
    int index = 0;
    TextView overView;
    ImageView imageViewXiamoi, imageViewXiamoi1, imageViewXiamoi2,imageViewXiamoi3;


    int[] images = {R.drawable.xiaomi, R.drawable.xiamoii, R.drawable.xiaomirop};

    TextView overView1, rating1, productDetails1, rec, overViewPlace, ratingPlace, productDetailsPlace, recPlace;

    TextView recommendation;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenging);
        //recyclerView = findViewById(R.id.recycler_view_daraz);
        ratingAndReviews = findViewById(R.id.rating_and_reviews);
        nestedScrollView = findViewById(R.id.nested_scroll_view);
        productDetails = findViewById(R.id.product_details);
        layout = findViewById(R.id.linear_layout1);
        imageSwitcher = findViewById(R.id.image_switcher);
        imageViewXiamoi = findViewById(R.id.image_view_xiamoi);
        imageViewXiamoi1 = findViewById(R.id.image_view_xiamoi1);
        imageViewXiamoi2 = findViewById(R.id.image_view_xiamoi2);
        imageViewXiamoi3 = findViewById(R.id.image_view_xiamoi3);
        overView = findViewById(R.id.over_view);
        recommendation = findViewById(R.id.recomand);


        //
        overView1 = findViewById(R.id.over_view1);
        rating1 = findViewById(R.id.rating1);
        productDetails1 = findViewById(R.id.product_details1);
        rec = findViewById(R.id.recommendation1);
        overViewPlace = findViewById(R.id.over_view_place);
        ratingPlace = findViewById(R.id.rating_place);
        productDetailsPlace = findViewById(R.id.pro_place);
        recPlace = findViewById(R.id.rec_place);

       overView1.setTextColor(Color.parseColor("#F57224"));


        overView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overViewPlace.setVisibility(View.VISIBLE);
                productDetailsPlace.setVisibility(View.INVISIBLE);
                ratingPlace.setVisibility(View.INVISIBLE);
                recPlace.setVisibility(View.INVISIBLE);
                overView1.setTextColor(Color.parseColor("#F57224"));
                productDetails1.setTextColor(Color.parseColor("#000000"));
                rec.setTextColor(Color.parseColor("#000000"));
                rating1.setTextColor(Color.parseColor("#000000"));
                nestedScrollView.smoothScrollTo(0, overView.getTop(), 2000);

            }
        });

        rating1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingPlace.setVisibility(View.VISIBLE);
                overViewPlace.setVisibility(View.INVISIBLE);
                productDetailsPlace.setVisibility(View.INVISIBLE);
                recPlace.setVisibility(View.INVISIBLE);
                rating1.setTextColor(Color.parseColor("#F57224"));
                productDetails1.setTextColor(Color.parseColor("#000000"));
                rec.setTextColor(Color.parseColor("#000000"));
                overView1.setTextColor(Color.parseColor("#000000"));
                //rating1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_place_24, 0, 0, 0);
                nestedScrollView.smoothScrollTo(0, ratingAndReviews.getTop(), 2000);
            }
        });
        productDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productDetailsPlace.setVisibility(View.VISIBLE);
                ratingPlace.setVisibility(View.INVISIBLE);
                overViewPlace.setVisibility(View.INVISIBLE);
                recPlace.setVisibility(View.INVISIBLE);
                productDetails1.setTextColor(Color.parseColor("#F57224"));
                rec.setTextColor(Color.parseColor("#000000"));
                overView1.setTextColor(Color.parseColor("#000000"));
                rating1.setTextColor(Color.parseColor("#000000"));
                //productDetails1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_place_24, 0, 0, 0);
                nestedScrollView.smoothScrollTo(0, productDetails.getTop(), 2000);
            }
        });
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recPlace.setVisibility(View.VISIBLE);
                productDetailsPlace.setVisibility(View.INVISIBLE);
                ratingPlace.setVisibility(View.INVISIBLE);
                overViewPlace.setVisibility(View.INVISIBLE);
                rec.setTextColor(Color.parseColor("#F57224"));
                productDetails1.setTextColor(Color.parseColor("#000000"));
                overView1.setTextColor(Color.parseColor("#000000"));
                rating1.setTextColor(Color.parseColor("#000000"));
                // rec.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_place_24, 0, 0, 0);
                nestedScrollView.smoothScrollTo(productDetails.getBottom(), imageViewXiamoi2.getTop(), 2000);
            }
        });


        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        imageSwitcher.setAnimation(in);
        imageSwitcher.setAnimation(out);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setMaxWidth(100);
                imageView.setMaxHeight(100);
                return imageView;

            }
        });
        imageSwitcher.setImageResource(images[index]);
        imageSwitcher.setImageResource(images[index++]);


        listOFString = new ArrayList<>();
        listOFString.add("Overview");


        if (nestedScrollView != null) {

            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                @Override
                public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    int measuredHeight = v.getMeasuredHeight() - v.getChildAt(0).getMeasuredHeight();
                    System.out.println(v.getMeasuredHeight());
                    System.out.println(measuredHeight);

                    if(scrollY >= overView.getTop() && scrollY < ratingAndReviews.getTop()) {
                        productDetailsPlace.setVisibility(View.INVISIBLE);
                        ratingPlace.setVisibility(View.INVISIBLE);
                        recPlace.setVisibility(View.INVISIBLE);
                        overViewPlace.setVisibility(View.VISIBLE);
                        productDetails1.setTextColor(Color.parseColor("#000000"));
                        overView1.setTextColor(Color.parseColor("#000000"));
                        rating1.setTextColor(Color.parseColor("#000000"));
                        overView1.setTextColor(Color.parseColor("#F57224"));

                    }
                    if(scrollY >= ratingAndReviews.getTop() && scrollY < productDetails.getTop()) {

                        ratingPlace.setVisibility(View.VISIBLE);
                        overViewPlace.setVisibility(View.INVISIBLE);
                        productDetailsPlace.setVisibility(View.INVISIBLE);
                        recPlace.setVisibility(View.INVISIBLE);
                        productDetails1.setTextColor(Color.parseColor("#000000"));
                        rec.setTextColor(Color.parseColor("#000000"));
                        overView1.setTextColor(Color.parseColor("#000000"));
                        rating1.setTextColor(Color.parseColor("#F57224"));

                        Log.i(TAG, "Scroll UP");
                    }
                    if(scrollY >= productDetails.getTop() && scrollY < recommendation.getTop()) {
                        productDetailsPlace.setVisibility(View.VISIBLE);
                        ratingPlace.setVisibility(View.INVISIBLE);
                        overViewPlace.setVisibility(View.INVISIBLE);
                        recPlace.setVisibility(View.INVISIBLE);
                        productDetails1.setTextColor(Color.parseColor("#F57224"));
                        rec.setTextColor(Color.parseColor("#000000"));
                        overView1.setTextColor(Color.parseColor("#000000"));
                        rating1.setTextColor(Color.parseColor("#000000"));


                      /*  if (scrollY == 0) {
                            Log.i(TAG, "TOP SCROLL");
                        }                        if (scrollY == (v.getMeasuredHeight() - v.getChildAt(0).getMeasuredHeight())) {


                            Log.i(TAG, "BOTTOM SCROLL");
                        }*/
                    }
                    if(scrollY >= recommendation.getTop()){
                        recPlace.setVisibility(View.VISIBLE);
                        productDetailsPlace.setVisibility(View.INVISIBLE);
                        ratingPlace.setVisibility(View.INVISIBLE);
                        overViewPlace.setVisibility(View.INVISIBLE);
                        rec.setTextColor(Color.parseColor("#F57224"));
                        productDetails1.setTextColor(Color.parseColor("#000000"));
                        overView1.setTextColor(Color.parseColor("#000000"));
                        rating1.setTextColor(Color.parseColor("#000000"));

                    }
                }
            });


        }
    }

    @Override
    public void showInterface(int position) {

    }
}

   /* @Override
    public void showInterface(int position) {
        // checking the data is coming or not  inside the showInterface
        Toast.makeText(this, "this is the position :" + position, Toast.LENGTH_SHORT).show();

        switch (position) {
            case 0:
                nestedScrollView.smoothScrollTo(0, overView.getTop(), 2000);
                break;
            case 1:
                nestedScrollView.smoothScrollTo(0, ratingAndReviews.getTop(), 2000);
                break;
            case 2:
                nestedScrollView.smoothScrollTo(0, productDetails.getTop(), 2000);
                break;
            case 3:
                nestedScrollView.smoothScrollTo(productDetails.getBottom(), imageViewXiamoi2.getTop(), 2000);
                break;
        }
  */
