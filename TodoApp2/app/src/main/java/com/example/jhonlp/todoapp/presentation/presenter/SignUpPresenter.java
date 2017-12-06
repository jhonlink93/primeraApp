package com.example.jhonlp.todoapp.presentation.presenter;

import com.example.jhonlp.todoapp.domain.model.User;
import com.example.jhonlp.todoapp.domain.usecase.UserUseCase;
import com.example.jhonlp.todoapp.domain.usecase.impl.UserUseCaseImpl;
import com.example.jhonlp.todoapp.helpers.Callback;

/**
 * Created by jhonlp on 02/12/2017.
 */

public class SignUpPresenter implements SignUpContract.UserActionsListener {

    private SignUpContract.View view;
    private UserUseCase userUseCase;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }


    public void onSignUp(String fullName, String email, String password) {

        userUseCase.signUp(fullName, email, password, new Callback<User>() {

            @Override
            public void success(User result) {
                view.goToLoginFragment();
            }
     public void error (Exception error){
            view.showMessageError(error);
            }
        });

    }
}
