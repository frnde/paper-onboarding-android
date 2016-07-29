package com.ramotion.paperonboarding.examples.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class FragmentsActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_activity_layout);
        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment bf = new BlankFragment();
                fragmentTransaction.replace(R.id.fragment_container, bf);
                fragmentTransaction.commit();
            }
        });
    }

    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // prepare data
        PaperOnboardingPage.Builder builderPageOne = new PaperOnboardingPage.Builder(R.color
                .colorAccent, R.drawable.hotels, R.drawable.key, R.string.hotel_title, R.string
                .hotel_description);

        PaperOnboardingPage.Builder builderPageTwo = new PaperOnboardingPage.Builder(R.color
                .colorPrimary, R.drawable.banks, R.drawable.wallet, R.string.banks_title, R.string
                .banks_description);

        PaperOnboardingPage.Builder builderPageThree = new PaperOnboardingPage.Builder(R.color
                .colorPrimaryDark, R.drawable.stores, R.drawable.shopping_cart, R.string.stores, R.string
                .stores_description);
        builderPageThree.withDescriptionColor(R.color.colorAccent);
        builderPageThree.withTitleColor(R.color.colorPrimary);
        builderPageThree.withBrandingIcon(R.drawable.brandingicon);

        PaperOnboardingPage pageOne = builderPageOne.build();
        PaperOnboardingPage pageTwo = builderPageTwo.build();
        PaperOnboardingPage pageThree = builderPageThree.build();

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(pageOne);
        elements.add(pageTwo);
        elements.add(pageThree);
        return elements;
    }
}
