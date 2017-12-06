package com.example.jhonlp.todoapp.domain.usecase;

import com.example.jhonlp.todoapp.domain.model.User;
import com.example.jhonlp.todoapp.helpers.Callback;

/**
 * Created by jhonlp on 02/12/2017.
 */

public interface UserUseCase {

    void login(String email, String password, boolean remember, Callback<User> callback);

    void signUp(String fullName, String email, String password, Callback<User> callback);

    void recoveryPassword(String email, Callback<Boolean> callback);

}
