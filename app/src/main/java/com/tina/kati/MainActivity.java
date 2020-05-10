package com.tina.kati;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tina.kati.login.LoginActivity;
import com.tina.kati.login.LoginFragment;
import com.tina.kati.wordcard.WordCardFragment;


public class MainActivity extends AppCompatActivity implements MainContract.View{

    private BottomNavigationView mBottomNavigation;
    private MainMvpController mMainMvpController;
    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, LoginActivity.class));

        setContentView(R.layout.activity_main);

        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.add(R.id.fragment_container, new WordCardFragment()).commit();

        mMainMvpController = MainMvpController.create(this);
        setBottomNavigation();
    }

    private void setBottomNavigation() {

        mBottomNavigation = findViewById(R.id.bottom_navigation_main);
        mBottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {

        switch (item.getItemId()) {
            case R.id.navigation_word_card:

                mPresenter.openWordCard();
                return true;

            case R.id.navigation_collection:

                mPresenter.openCollection();
                return true;

            case R.id.navigation_profile:

                mPresenter.openProfile();
                return true;

            default:
                return false;
        }
    };




    @Override
    public void openWordCardUi() {
        mMainMvpController.findOrCreateWordCardFragment();
    }

    @Override
    public void openCollectionUi() {
        mMainMvpController.findOrCreateCollectionFragment();
    }

    @Override
    public void openProfileUi() {
        mMainMvpController.findOrCreateProfileFragment();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
