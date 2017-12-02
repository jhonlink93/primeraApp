package com.example.jhonlp.todoapp.presentation.presenter;

/**
 * Created by jhonlp on 02/12/2017.
 */

public class LoginPresenter implements  LoginContract.UserActionListener {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String email, String password, boolean remember) {

    }
}
