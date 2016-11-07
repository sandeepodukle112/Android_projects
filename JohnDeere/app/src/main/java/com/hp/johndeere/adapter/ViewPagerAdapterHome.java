package com.hp.johndeere.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hp.johndeere.R;
import com.hp.johndeere.model.GridBean;

import java.util.ArrayList;


public class ViewPagerAdapterHome extends PagerAdapter {
    private Context context;
    private ArrayList<GridBean> arrayList;
    private LayoutInflater inflater;

    public ViewPagerAdapterHome(Context context, ArrayList<GridBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView ivImage;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_adapter_home, container, false);
        ivImage = (ImageView) itemView.findViewById(R.id.ivImage);

        ivImage.setImageDrawable(context.getResources().getDrawable(R.drawable.image_banner1));

        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout) object);

    }

    public class ViewHolder {
        private ImageView ivImage;
    }
}
