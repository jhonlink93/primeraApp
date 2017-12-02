package com.example.jhonlp.todoapp.presentation.view.fragment;

/**
 * Created by jhonlp on 02/12/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jhonlp.todoapp.*;
import com.example.jhonlp.todoapp.presentation.presenter.LoginContract;
import com.example.jhonlp.todoapp.presentation.presenter.SignUpContract;
import com.example.jhonlp.todoapp.presentation.view.activity.AuthActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SignUpContract.View {


    public SignUpFragment() {
        // Required empty public constructor
    }


    public static SignUpFragment getInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        return view;
    }

    @Override
    public void goToLoginFragment() {
        getChildFragmentManager().popBackStack();
    }

    @Override
    public void goToMainActivity() {

    }
}