package com.example.jhonlp.todoapp.helpers;

/**
 * Created by jhonlp on 02/12/2017.
 */
import com.example.jhonlp.todoapp.domain.model.User;

/**
 * Created by krlosf on 2/12/17.
 */

public interface Callback<T> {
    void success(T result);

    void error(Exception error);
}