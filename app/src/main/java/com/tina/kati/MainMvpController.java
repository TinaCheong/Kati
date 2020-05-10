package com.tina.kati;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.tina.kati.collection.CollectionFragment;
import com.tina.kati.profile.ProfileFragment;
import com.tina.kati.util.ActivityUtils;
import com.tina.kati.wordcard.WordCardFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static androidx.core.util.Preconditions.checkNotNull;

public class MainMvpController {

    private final FragmentActivity mActivity;
    private MainPresenter mMainPresenter;

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            WORD_CARD, COLLECTION, PROFILE
    })
    public @interface FragmentType {}
    static final String WORD_CARD = "WORD_CARD";
    static final String COLLECTION = "COLLECTION";
    static final String PROFILE = "PROFILE";

    private MainMvpController(@NonNull FragmentActivity activity) {
        mActivity = activity;
    }

    static MainMvpController create(@NonNull FragmentActivity activity) {
        checkNotNull(activity);
        MainMvpController mainMvpController = new MainMvpController(activity);
        mainMvpController.createMainPresenter();
        return mainMvpController;
    }


    @NonNull
    public WordCardFragment findOrCreateWordCardFragment() {

        WordCardFragment wordCardFragment =
                (WordCardFragment) getFragmentManager().findFragmentById(R.id.fragment_word_card);

        if (wordCardFragment == null) {
            wordCardFragment = new WordCardFragment();
        }

        ActivityUtils.showOrAddFragmentByTag(
                getFragmentManager(), wordCardFragment, PROFILE);

        return wordCardFragment;
    }

    @NonNull
    public CollectionFragment findOrCreateCollectionFragment() {

        CollectionFragment collectionFragment =
                (CollectionFragment) getFragmentManager().findFragmentById(R.id.fragment_collection);

        if (collectionFragment == null) {
            collectionFragment = new CollectionFragment();
        }

        ActivityUtils.showOrAddFragmentByTag(
                getFragmentManager(), collectionFragment, PROFILE);

        return collectionFragment;
    }


    @NonNull
    public ProfileFragment findOrCreateProfileFragment() {

        ProfileFragment profileFragment =
                (ProfileFragment) getFragmentManager().findFragmentById(R.id.fragment_profile);

        if (profileFragment == null) {
            profileFragment = new ProfileFragment();
        }

        ActivityUtils.showOrAddFragmentByTag(
                getFragmentManager(), profileFragment, PROFILE);

        return profileFragment;
    }


    private MainPresenter createMainPresenter() {
        mMainPresenter = new MainPresenter((MainActivity) mActivity);

        return mMainPresenter;
    }

    private FragmentManager getFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

}
