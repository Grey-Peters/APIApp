package com.example.groupproject.finalproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * AD340 Final Project
 * Group Members: RJ Hunter, Ian Peters, Stephen Teacher
 *
 * post class provides functionality for fragment
 */
public class postFragment extends Fragment{

    public postFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // returns the root view for the fragment
        View rootView = inflater.inflate(R.layout.fragment_post, container, false);
        return rootView;
    }





}
