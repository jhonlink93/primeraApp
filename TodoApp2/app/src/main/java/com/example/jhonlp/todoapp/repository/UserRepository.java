package com.example.jhonlp.todoapp.repository;

import com.example.jhonlp.todoapp.domain.model.User;
import com.example.jhonlp.todoapp.helpers.Callback;

/**
 * Created by jhonlp on 02/12/2017.
 */
public interface UserRepository {

    void login(String email, String password, Callback<User> callback);

    void signUp(User user, Callback<User> callback);

    void recoveryPassword(String email, Callback<Boolean> callback);
}
