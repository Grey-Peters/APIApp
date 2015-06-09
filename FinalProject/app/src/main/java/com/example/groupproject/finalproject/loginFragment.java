package com.example.groupproject.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * AD340 Final Project
 * Group Members: RJ Hunter, Ian Peters, Stephen Teacher
 *
 * Login class provides functionality for fragment
 */
public class loginFragment extends Fragment{

        private TextView mTextDetails;
        private CallbackManager mCallbackManager;
        private Profile profile;
        private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
            // implements methods for facebook callback
            @Override
            public void onSuccess(LoginResult loginResult) {
                // creates token and profile
                AccessToken accessToken = loginResult.getAccessToken();
                profile = Profile.getCurrentProfile();
                // checks if profile is null
                if (profile != null) {
                    // if the profile exists, loads the next activity
                    Intent intent = new Intent(getActivity(), PostActivity.class);
                    startActivity(intent);
                }


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        };

        public loginFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // initializes facebook sdk and creates callback manager
            FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
            mCallbackManager = CallbackManager.Factory.create();


        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            // returns the root view for the fragment
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // initializes the facebook login button
            LoginButton loginbutton = (LoginButton) view.findViewById(R.id.login_button);
            loginbutton.setFragment(this);
            loginbutton.registerCallback(mCallbackManager, mCallback);

        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            // gathers activity result data
            mCallbackManager.onActivityResult(requestCode, resultCode, data);
        }




}
