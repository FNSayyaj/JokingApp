package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.aboelfer.knightrider.ajokelib.JokeActivity;


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

        // Set onClickListener for the button
        Button button = root.findViewById(R.id.button);
        button.setOnClickListener(v -> getJoke());

        return root;
    }

    public void getJoke(){
        new EndpointAsyncTask().execute( this);
    }

    public void launchDisplayJokeActivity(){

        if (!testFlag) {

            Intent intent = new Intent(getContext(), JokeActivity.class);
            intent.putExtra(getString(R.string.JOKE_KEY), loadedJoke);
            startActivity(intent);
        }
    }

}
