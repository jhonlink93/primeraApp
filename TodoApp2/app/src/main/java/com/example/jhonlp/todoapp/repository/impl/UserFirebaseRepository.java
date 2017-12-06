package com.example.jhonlp.todoapp.repository.impl;

/**
 * Created by jhonlp on 02/12/2017.
 */
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.jhonlp.todoapp.domain.model.User;
import com.example.jhonlp.todoapp.helpers.Callback;
import com.example.jhonlp.todoapp.presentation.view.fragment.RecoveryPasswordFragment;
import com.example.jhonlp.todoapp.repository.UserRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserFirebaseRepository implements UserRepository {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public UserFirebaseRepository() {
        this.mAuth = FirebaseAuth.getInstance();
        this.mDatabase = FirebaseDatabase.getInstance()
                .getReference("users");
    }

    @Override
    public void login(String email, String password, final Callback<User> callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful() && task.getResult() != null) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            mDatabase.child(firebaseUser.getUid())
                                    .addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            User user = dataSnapshot.getValue(User.class);
                                            callback.success(user);
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            callback.error(databaseError.toException());
                                        }
                                    });
                        } else {
                            callback.error(task.getException());
                        }
                    }
                });
    }


    @Override
    public void recoveryPassword(String email, final Callback<Boolean> callback) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //Respuesta del envio del correo de recuperacion de contraseña
                        if(task.isSuccessful()) {
                            callback.success(true);
                        } else {
                            callback.error(task.getException());
                        }
                    }
                });
    }

    @Override
    public void signUp(final User user, final Callback<User> callback) {

        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Respuesta de la creacion del usuario en FirebaseAuthentication
                        if(task.isSuccessful() && task.getResult() != null) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            user.setId(firebaseUser.getUid());
                            user.setPassword(null);
                            mDatabase.child(user.getId()).setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            //Respuesta de la creacion del usuario en FirebaseDatabase
                                            if(task.isSuccessful()) {
                                                callback.success(user);
                                            } else {
                                                callback.error(task.getException());
                                            }
                                        }
                                    });
                        } else {
                            callback.error(task.getException());
                        }
                    }
                });
    }
}