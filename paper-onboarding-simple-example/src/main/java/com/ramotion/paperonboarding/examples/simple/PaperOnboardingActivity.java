package com.ramotion.paperonboarding.examples.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class PaperOnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_main_layout);

        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView),
                getDataForOnboarding(), getApplicationContext());

        engine.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int oldElementIndex, int newElementIndex) {
                Toast.makeText(getApplicationContext(), "Swiped from " + oldElementIndex + " to " +
                        newElementIndex, Toast.LENGTH_SHORT).show();
            }
        });

        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                // Probably here will be your exit action
                Toast.makeText(getApplicationContext(), "Swiped out right", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Just example data for Onboarding
    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // prepare data
        // prepare data
        PaperOnboardingPage.Builder buildePageOne = new PaperOnboardingPage.Builder(R.color
                .colorAccent, R.drawable.hotels, R.drawable.key, R.string.hotel_title, R.string
                .hotel_description);

        PaperOnboardingPage.Builder buildePageTwo = new PaperOnboardingPage.Builder(R.color
                .colorPrimary, R.drawable.banks, R.drawable.wallet, R.string.banks_title, R.string
                .banks_description);

        PaperOnboardingPage.Builder buildePageThree = new PaperOnboardingPage.Builder(R.color
                .colorPrimaryDark, R.drawable.stores, R.drawable.shopping_cart, R.string.stores, R.string
                .stores_description);
        buildePageThree.withDescriptionColor(R.color.colorAccent);
        buildePageThree.withTitleColor(R.color.colorPrimary);
        buildePageThree.withBrandingIcon(R.drawable.brandingicon);

        PaperOnboardingPage pageOne = buildePageOne.build();
        PaperOnboardingPage pageTwo = buildePageTwo.build();
        PaperOnboardingPage pageThree = buildePageThree.build();

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(pageOne);
        elements.add(pageTwo);
        elements.add(pageThree);
        return elements;
    }
}
