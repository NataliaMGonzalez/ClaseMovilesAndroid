package com.example.viewmodelexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);

        final Observer<Integer> scoreAObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView scoreView = (TextView) findViewById(R.id.team_a_score);
                scoreView.setText(String.valueOf(integer));
            }
        };

        final Observer<Integer> scoreBObserver = new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView scoreView = (TextView) findViewById(R.id.team_b_score);
                scoreView.setText(String.valueOf(integer));
            }
        };

        mViewModel.getScoreTeamA().observe(this, scoreAObserver);
        mViewModel.getScoreTeamB().observe(this, scoreBObserver);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        mViewModel.setScoreTeamA(1);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        mViewModel.setScoreTeamA(2);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        mViewModel.setScoreTeamA(3);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        mViewModel.setScoreTeamB(1);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        mViewModel.setScoreTeamB(2);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        mViewModel.setScoreTeamB(3);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        mViewModel.resetScores();
    }

}