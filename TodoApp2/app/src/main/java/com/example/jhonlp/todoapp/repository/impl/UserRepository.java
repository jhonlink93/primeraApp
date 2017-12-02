package com.example.jhonlp.todoapp.repository.impl;

import com.example.jhonlp.todoapp.domain.model.User;

/**
 * Created by jhonlp on 02/12/2017.
 */
public interface UserRepository {

    void login(String email, String password);
    void signUp(User user);
}
