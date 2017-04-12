package com.example.android.expansequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.expansequiz.R;

public class MainActivity extends AppCompatActivity {

    String name;
    int score;
    EditText username;
    RadioButton mormonShip;
    CheckBox firstCheckbox;
    CheckBox secondCheckbox;
    CheckBox thirdCheckbox;
    CheckBox fourthCheckbox;
    EditText opaMeaning;
    EditText rocinanteName;
    EditText julieMao;
    RadioButton donangerWarship;
    RadioButton tychoStation;
    RadioButton earthFirst;



    View button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (View) findViewById(R.id.score_button);

        mormonShip = (RadioButton) findViewById(R.id.mormon);
        firstCheckbox = (CheckBox) findViewById(R.id.first_checkbox);
        secondCheckbox = (CheckBox) findViewById(R.id.second_checkbox);
        thirdCheckbox = (CheckBox) findViewById(R.id.third_checkbox);
        fourthCheckbox = (CheckBox) findViewById(R.id.fourth_checkbox);
        opaMeaning = (EditText) findViewById(R.id.opa_meaning);
        rocinanteName = (EditText) findViewById(R.id.rocinante);
        julieMao = (EditText) findViewById(R.id.julie_mao);
        donangerWarship = (RadioButton) findViewById(R.id.donanger_warship);
        tychoStation = (RadioButton) findViewById(R.id.tycho_shipyard);
        earthFirst = (RadioButton) findViewById(R.id.earth_come_first);
        username = (EditText) findViewById(R.id.user_name);

        button.startAnimation(AnimationUtils.loadAnimation(this, R.anim.pulse));
    }

    public void showScore(View view) {

        //Q1
        String firstAnswerText = String.valueOf(username.getText());
        boolean firstAnswer = true;
        if (firstAnswerText.equals("")) {
            firstAnswer = false;
        }

        //Q2
        boolean secondAnswer1 = firstCheckbox.isChecked();
        boolean secondAnswer2 = secondCheckbox.isChecked();
        boolean secondAnswer3 = thirdCheckbox.isChecked();
        boolean secondAnswer4 = fourthCheckbox.isChecked();

        //Q3
        String thirdAnswerText = String.valueOf(opaMeaning.getText());
        boolean thirdAnswer = false;
        if (thirdAnswerText.equals("Outer Planets Alliance")) {
            thirdAnswer = true;
        }

        //Q4
        boolean fourthAnswer = false;
        if (rocinanteName.getText().toString().equals("Tachi")) {
            fourthAnswer = true;
        }

        //Q5
        boolean fifthAnswer = false;
        if (julieMao.getText().toString().equals("Julie Mao")) {
            fifthAnswer = true;
        }

        //Q6
        boolean sixthAnswer = donangerWarship.isChecked();

        //Q7
        boolean seventhAnswer = tychoStation.isChecked();

        //Q8
        boolean eighthAnswer = earthFirst.isChecked();

        //Q9
        boolean nineAnswer = mormonShip.isChecked();

        calculateScore(firstAnswer, secondAnswer1, secondAnswer2, secondAnswer3, secondAnswer4, thirdAnswer, fourthAnswer, fifthAnswer, sixthAnswer, seventhAnswer, eighthAnswer, nineAnswer);

        name = String.valueOf(username.getText());

        displayScore(score, name);
    }

    public int calculateScore(boolean firstAnswer, boolean secondAnswer1, boolean secondAnswer2, boolean secondAnswer3, boolean secondAnswer4, boolean thirdAnswer, boolean fourthAnswer, boolean fifthAnswer, boolean sixthAnswer, boolean seventhAnswer, boolean eighthAnswer, boolean nineAnswer) {

        if (firstAnswer) {
            score = score + 1;
        }

        if (secondAnswer1 && secondAnswer4 && secondAnswer3 && !secondAnswer2) {
            score = score + 1;
        }

        if (thirdAnswer) {
            score = score + 1;
        }

        if (fourthAnswer) {
            score = score + 1;
        }

        if (fifthAnswer) {
            score = score + 1;
        }

        if (sixthAnswer) {
            score = score + 1;
        }

        if (seventhAnswer) {
            score = score + 1;
        }

        if (eighthAnswer) {
            score = score + 1;
        }

        if (nineAnswer) {
            score = score + 1;
        }

        return score;

    }

    public void displayScore(int score, String name) {
        if (!name.equals("")) {

            if (score == 0) {
                Toast.makeText(this, "Come on, " + name + "! You scored 0 points! You can do better! Try again!", Toast.LENGTH_LONG).show();
            } else if (score < 5) {
                Toast.makeText(this, "Not bad, " + name + "! Your score is: " + score + "/8. You can do better! Try again!", Toast.LENGTH_LONG).show();
            } else if (score == 7) {
                Toast.makeText(this, "You are great " + name + "! Your score is: " + score + "/8. Only one right answer from being perfect!", Toast.LENGTH_LONG).show();
            } else if (score == 8) {
                Toast.makeText(this, "You are such a genious " + name + "! Your score is: " + score + "/8. IT'S JUST PERFECT! Congratulations!", Toast.LENGTH_LONG).show();
            } else if (score >= 5) {
                Toast.makeText(this, "Good, " + name + "! Your score is: " + score + "/8. You answered more than half of the question right!", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "You need to answer the first question!", Toast.LENGTH_LONG).show();
        }
    }
}
