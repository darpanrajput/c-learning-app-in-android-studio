package com.darpan.learnc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.darpan.learnc.Adapters.SliderAdpter;
//import com.darpan.letuscverone.Adapters.SliderAdpter;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPagerSlider;
    private LinearLayout dotLayouts;
    private SliderAdpter sliderAdpter;
    private TextView[] mdots;
    private Button backBtn;
    private Button nextBtn;
    int Currentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (restorePrefData()) {

            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();


        }

        setContentView(R.layout.activity_view_pager);

        dotLayouts = findViewById(R.id.dots);
        viewPagerSlider = findViewById(R.id.viewPager);
        sliderAdpter = new SliderAdpter(this);
        viewPagerSlider.setAdapter(sliderAdpter);
        addDotsIndicators(0);
        viewPagerSlider.addOnPageChangeListener(viewListener);
        backBtn = findViewById(R.id.prev);
        nextBtn = findViewById(R.id.next);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePrefsData();
                if (Currentpage == 2) {
                    Intent intent = new Intent(ViewPagerActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
                viewPagerSlider.setCurrentItem(Currentpage + 1);

            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPagerSlider.setCurrentItem(Currentpage - 1);
            }
        });

    }

    public void addDotsIndicators(int position) {
        mdots = new TextView[3];
        dotLayouts.removeAllViews();
        for (int i = 0; i < mdots.length; i++) {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextColor(getResources().getColor(R.color.grey));
            mdots[i].setTextSize(35);
            dotLayouts.addView(mdots[i]);
        }
        if (mdots.length > 0) {
            mdots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicators(i);
            Currentpage = i;
            if (Currentpage == 0) {
                nextBtn.setEnabled(true);
                backBtn.setEnabled(false);
                backBtn.setVisibility(View.INVISIBLE);
                nextBtn.setText("Next");
                backBtn.setText("");
            } else if (Currentpage == mdots.length - 1) {

                nextBtn.setEnabled(true);
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);
                nextBtn.setText("Finish");
                backBtn.setText("Back");
            } else {
                nextBtn.setEnabled(true);
                backBtn.setEnabled(true);
                backBtn.setVisibility(View.VISIBLE);
                nextBtn.setText("Next");
                backBtn.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private boolean restorePrefData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend", false);
        return isIntroActivityOpnendBefore;


    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend", true);
        editor.commit();


    }

}


