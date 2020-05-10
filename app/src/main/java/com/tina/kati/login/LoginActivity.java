package com.tina.kati.login;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.tina.kati.R;

public class LoginActivity extends FragmentActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.login_fragment_container, new LoginFragment()).commit();
    }
}
