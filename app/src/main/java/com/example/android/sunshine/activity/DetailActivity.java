package com.example.android.sunshine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.app.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, new DetailActivityFragment())
                    .commit();
        }
    }

    public static class DetailActivityFragment extends Fragment {

        public DetailActivityFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Intent intent = getActivity().getIntent();

            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            TextView forecastTextView = (TextView) rootView.findViewById(R.id.forecast_detail_textview);

            if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
                String forecastString = intent.getStringExtra(Intent.EXTRA_TEXT);

                Log.i("Test", "Let see");
                Log.i("Test", forecastString);
                Log.i("Test", "Done");

                forecastTextView.setText(forecastString);
            }

            return rootView;
        }
    }
}
