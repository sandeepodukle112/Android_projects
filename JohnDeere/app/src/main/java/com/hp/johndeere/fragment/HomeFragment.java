package com.hp.johndeere.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hp.johndeere.R;
import com.hp.johndeere.activity.MainActivity;
import com.hp.johndeere.adapter.HomeGridAdapter;
import com.hp.johndeere.adapter.ViewPagerAdapterHome;
import com.hp.johndeere.model.GridBean;
import com.hp.johndeere.util.NonSwapableViewPager;

import java.util.ArrayList;

/**
 * Created by hp on 5/11/16.
 */
public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    private Context context;
    private View view;
    private NonSwapableViewPager vpMain;
    private ViewPagerAdapterHome pagerAdapterHome;
    private ArrayList<GridBean> mImageSlidesList;
    private int currentPage = 0, mTotalPages = 0,dotsCount;
    private ImageView[] imageViewDots;
    private LinearLayout linearLayoutPageIndicator;
    private GridView gvMain;
    private ArrayList<GridBean> listGrid;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MainActivity.tvTitle.setText(R.string.home);

        view = inflater.inflate(R.layout.fragment_home, container, false);
        findViews();
        return view;
    }

    private void findViews() {
        vpMain = (NonSwapableViewPager) view.findViewById(R.id.vpMain);
        gvMain = (GridView) view.findViewById(R.id.gvMain);
        linearLayoutPageIndicator = (LinearLayout) view.findViewById(R.id.linearLayoutPageIndicator);

        listGrid = new ArrayList<>();
        listGrid.add(new GridBean("CULTIVATE", R.drawable.image_banner1 + ""));
        listGrid.add(new GridBean("PLOUGH", R.drawable.image_banner1 + ""));
        listGrid.add(new GridBean("HAULAGE", R.drawable.image_banner1 + ""));
        listGrid.add(new GridBean("SEED DRILL", R.drawable.image_banner1 + ""));
        HomeGridAdapter gridAdapter = new HomeGridAdapter(getContext(), listGrid);
        gvMain.setAdapter(gridAdapter);

        mImageSlidesList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mImageSlidesList.add(new GridBean("" + i, "" + i));
        }
        mTotalPages = mImageSlidesList.size();
        pagerAdapterHome = new ViewPagerAdapterHome(context, mImageSlidesList);
        vpMain.setAdapter(pagerAdapterHome);
        if (MainActivity.isScrolling) {
            autoSlidePagerImages();
        }
        vpMain.addOnPageChangeListener(this);
        setPagerIndicator();
        //setListenerOnGridItems();
    }

    private void autoSlidePagerImages() {
        MainActivity.isScrolling = false;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentPage == mTotalPages) {
                    currentPage = 0;
                }
                vpMain.setCurrentItem(currentPage++, true);
                autoSlidePagerImages();
            }
        }, 8000);

    }

    private void setPagerIndicator() {

        dotsCount = pagerAdapterHome.getCount();
        imageViewDots = new ImageView[dotsCount];

        Log.d("size", String.valueOf(dotsCount));
        for (int i = 0; i < dotsCount; i++) {
            imageViewDots[i] = new ImageView(context);
            imageViewDots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot_white));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(4, 0, 4, 0);
            linearLayoutPageIndicator.addView(imageViewDots[i], params);
        }
        imageViewDots[0].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        try {
            for (int i = 0; i < dotsCount; i++) {
                imageViewDots[i].setImageDrawable(getResources().getDrawable(R.drawable.non_selected_item_dot_white));
            }

            imageViewDots[position].setImageDrawable(getResources().getDrawable(R.drawable.selected_item_dot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
