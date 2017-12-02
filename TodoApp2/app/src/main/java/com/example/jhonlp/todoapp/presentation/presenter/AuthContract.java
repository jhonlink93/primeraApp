package com.example.jhonlp.todoapp.presentation.presenter;

/**
 * Created by jhonlp on 02/12/2017.
 */

public interface AuthContract {

    // It will implement Fragment and Activity
    interface View {
        void goToLoginFragment();
        void goMainActivity();
    }

    // It will implement to presenter
    interface  UserActionListener {
        void goToFirstFragment();
    }
}
