package com.example.jhonlp.todoapp.presentation.presenter;

import com.example.jhonlp.todoapp.domain.model.User;
import com.example.jhonlp.todoapp.domain.usecase.UserUseCase;
import com.example.jhonlp.todoapp.domain.usecase.impl.UserUseCaseImpl;
import com.example.jhonlp.todoapp.helpers.Callback;

/**
 * Created by jhonlp on 02/12/2017.
 */

public class LoginPresenter implements  LoginContract.UserActionListener {


    private LoginContract.View view;
    private UserUseCase userUseCase;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onLogin(String email, String password, boolean remember) {
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User user) {
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }

}
