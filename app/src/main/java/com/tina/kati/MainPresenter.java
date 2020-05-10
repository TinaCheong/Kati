package com.tina.kati;

import androidx.annotation.NonNull;

import static androidx.core.util.Preconditions.checkNotNull;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;

    public MainPresenter(@NonNull MainContract.View mainView) {
        mMainView = checkNotNull(mainView, "mainView cannot be null!");
        mMainView.setPresenter(this);
    }

    @Override
    public void openWordCard() {
        mMainView.openWordCardUi();
    }

    @Override
    public void openCollection() {
        mMainView.openCollectionUi();
    }

    @Override
    public void openProfile() {
        mMainView.openProfileUi();
    }

    @Override
    public void start() {

    }
}
