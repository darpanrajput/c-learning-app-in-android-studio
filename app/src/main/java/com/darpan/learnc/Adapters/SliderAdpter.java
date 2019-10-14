package com.darpan.learnc.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.darpan.learnc.R;


public class SliderAdpter extends PagerAdapter {
    Context mcomtext;
    LayoutInflater layoutInflater;

    public SliderAdpter(Context mcomtext) {
        this.mcomtext = mcomtext;
    }

    public int[] SlideImage={
        R.drawable.slide_one_image,
    R.drawable.slide_wo_image,
    R.drawable.slide_three_image

    };
  public int[] SlideText={
          R.string.first_slide_text,
          R.string.scond_slide_text,
          R.string.third_slide_text


  };

    @Override
    public int getCount() {
        return SlideImage.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
     layoutInflater= (LayoutInflater) mcomtext.getSystemService(mcomtext.LAYOUT_INFLATER_SERVICE);
     View v=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView imageView=v.findViewById(R.id.SlideImageone);
        TextView textView=v.findViewById(R.id.SlideTextView);
        imageView.setImageResource(SlideImage[position]);
        textView.setText(SlideText[position]);
        container.addView(v);
     return v;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}



