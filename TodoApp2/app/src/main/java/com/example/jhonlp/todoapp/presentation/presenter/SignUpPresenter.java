package com.example.jhonlp.todoapp.presentation.presenter;

import com.example.jhonlp.todoapp.domain.model.User;

/**
 * Created by jhonlp on 02/12/2017.
 */

public class SignUpPresenter implements SignUpContract.UserActionListener {

    private SignUpContract.View view;


    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void onSignUp(String fullName, String emial, String password) {
        

    }
}
