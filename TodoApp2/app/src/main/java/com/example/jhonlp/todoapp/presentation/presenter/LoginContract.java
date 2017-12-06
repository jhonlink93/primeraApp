package com.example.jhonlp.todoapp.presentation.presenter;

/**
 * Created by jhonlp on 02/12/2017.
 */

public interface LoginContract {

    interface View {
        void goToSignUpFragment();
        void goToMainActivity();

        void showMessageError(Exception error);
    }

    void showMessageError(Exception error);

    interface UserActionListener {
        void onLogin(String email, String password, boolean remember);
    }

}
