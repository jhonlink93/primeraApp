package com.example.jhonlp.todoapp.presentation.presenter;

/**
 * Created by jhonlp on 02/12/2017.
 */

public interface SignUpContract {

    interface View {
        void goToLoginFragment();

        void goToMainActivity();
    }

    interface UserActionListener {
        void onSignUp(String fullName, String emial, String password);
    }
}