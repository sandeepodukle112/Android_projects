package com.hp.johndeere.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hp.johndeere.R;
import com.hp.johndeere.activity.MainActivity;

/**
 * Created by hp on 5/11/16.
 */
public class HomeFragment extends BaseFragment {
    private Context context;
    private View view;

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

    }
}
