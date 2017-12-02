package com.example.jhonlp.todoapp.presentation.presenter;

/**
 * Created by jhonlp on 02/12/2017.
 */

public class AuthPresenter implements AuthContract.UserActionListener {

    private AuthContract.View view;

    public AuthPresenter(AuthContract.View view) {
        this.view = view;
    }

    @Override
    public void goToFirstFragment() {
        view.goToLoginFragment();

        //  view.goMainActivity();
    }
}