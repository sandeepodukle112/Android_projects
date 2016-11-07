package com.hp.johndeere.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.hp.johndeere.R;
import com.hp.johndeere.model.GridBean;

import java.util.ArrayList;


/**
 * Created by android-14 on 16/1/16.
 */
public class HomeGridAdapter extends BaseAdapter {

    Context context;
    ArrayList<GridBean> mNavigationBean;
    private LayoutInflater inflater;

    public HomeGridAdapter(Context context, ArrayList<GridBean> mNavigationBean) {
        this.mNavigationBean = mNavigationBean;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mNavigationBean.size();
    }

    @Override
    public Object getItem(int i) {
        return mNavigationBean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.grid_adapter_home, null);
            viewHolder.ivItemImage = (ImageView) view.findViewById(R.id.ivItemImage);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

         viewHolder.ivItemImage.setImageResource(Integer.parseInt(mNavigationBean.get(i).getImage()));
        viewHolder.tvTitle.setText(mNavigationBean.get(i).getTitle());

        return view;
    }

    public class ViewHolder {
        private TextView tvTitle;
        private ImageView ivItemImage;
    }

}
