package com.manthan.manthan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Achievements extends Fragment {

    public Achievements() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View myView = inflater.inflate(R.layout.fragment_achievements, container, false);
        return myView;
    }
}