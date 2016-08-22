package com.gsinexample.pranay.customviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int[] drawableImages = new int[]{R.drawable.e,R.drawable.f,R.drawable.e};
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new MyAdapter(MainActivity.this));
        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20*2,     getResources().getDisplayMetrics());
        viewPager.setPageMargin(-margin);
        viewPager.setClipToPadding(false);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
              /*  LayoutInflater inflater = null;
                LinearLayout view = (LinearLayout) inflater.inflate(R.layout.vps,null,true);
                view.setLayoutParams(new LinearLayout.LayoutParams());*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        viewPager.setPadding(margin/2,0,margin/2,0);

     /*   viewPager.setPadding(20, 0, 20, 0);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(10);
*/
    }

    public class MyAdapter extends PagerAdapter {

        LayoutInflater inflater;
        Context context;

        public MyAdapter(MainActivity mainActivity) {
            this.context = mainActivity;
        }

        @Override
        public int getCount() {
            return drawableImages.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((LinearLayout) object);

        }

        @Override
        public Object instantiateItem(View container, int position) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.vps,null,true);
            ImageView imgImg= (ImageView) view.findViewById(R.id.ivp);
            imgImg.setImageResource(drawableImages[position]);
            ((ViewPager) container).addView(view);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

      /*  @Override
        public float getPageWidth(int position) {
            return 0.5f;
        }*/
    }
}
