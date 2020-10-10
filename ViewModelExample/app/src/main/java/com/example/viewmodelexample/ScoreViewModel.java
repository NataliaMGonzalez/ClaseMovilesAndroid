package com.example.viewmodelexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    // Tracks the score for Team A
    private MutableLiveData<Integer> scoreTeamA = new MutableLiveData<>();

    // Tracks the score for Team B
    private MutableLiveData<Integer> scoreTeamB = new MutableLiveData<>();

    public ScoreViewModel(){
        scoreTeamA.setValue(0);
        scoreTeamB.setValue(0);
    }

    public MutableLiveData<Integer>  getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int score) {
        this.scoreTeamA.setValue(this.scoreTeamA.getValue() + score);
    }

    public MutableLiveData<Integer>  getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int score) {
        this.scoreTeamB.setValue(this.scoreTeamB.getValue() + score);
    }

    public void resetScores() {
        scoreTeamA.setValue(0);
        scoreTeamB.setValue(0);
    }


}
