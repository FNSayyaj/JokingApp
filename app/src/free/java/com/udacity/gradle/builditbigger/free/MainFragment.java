package com.udacity.gradle.builditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.aboelfer.knightrider.ajokelib.JokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.R;


public class MainFragment extends Fragment {


    public MainFragment() {
    }

    public static String loadedJoke = null;
    public static boolean testIsReady = false;
    public boolean testFlag = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        // Set onClickListener for the button
        Button button = root.findViewById(R.id.button);
        button.setOnClickListener(v -> getJoke());

        return root;
    }

    public void getJoke() {
        new EndpointAsyncTask().execute(this);
    }

    public void launchDisplayJokeActivity() {

        if (!testFlag) {
            Intent intent = new Intent(getContext(), JokeActivity.class);
            intent.putExtra("JOKE", loadedJoke);
            startActivity(intent);
        }
    }
}

