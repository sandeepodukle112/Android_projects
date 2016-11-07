package com.hp.johndeere.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hp.johndeere.R;

public class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}
