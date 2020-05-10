package com.tina.kati;

import android.content.Intent;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void openWordCardUi();

        void openCollectionUi();

        void openProfileUi();

    }

    interface Presenter extends BasePresenter {

        void openWordCard();

        void openCollection();

        void openProfile();
    }
}
