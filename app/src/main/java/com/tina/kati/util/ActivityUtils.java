package com.tina.kati.util;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tina.kati.MainMvpController;
import com.tina.kati.R;



public class ActivityUtils {

    public static void showOrAddFragmentByTag(@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment,
                                              @MainMvpController.FragmentType String fragmentTag) {
//        checkNotNull(fragmentManager);
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        for (Fragment element : fragmentManager.getFragments()) {
            if (!element.isHidden()) {
                transaction.hide(element);
                break;
            }
        }

        if (fragment.isAdded()) {
            transaction.show(fragment);
        } else {
            transaction.add(R.id.fragment_container, fragment, fragmentTag);
        }

        transaction.commit();
    }

}
