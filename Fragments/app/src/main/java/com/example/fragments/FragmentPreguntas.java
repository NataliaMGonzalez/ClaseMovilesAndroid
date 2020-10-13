package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPreguntas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPreguntas extends Fragment {

    private static final int FALSE = 1;
    private static final int TRUE = 0;

    private static final int DEPORTES = 10;
    private static final int TECNOLOGIA = 11;

    private String[] questions = new String[2];
    private boolean[][] answers = {
            {true, false},
            {false, true}
    };

    private static int curr_state;
    private int curr_question;

    TextView tv_question;
    TextView tv_currQuestion;

    Button next_btn;
    Button prev_btn;
    Button checkAnswer;

    RadioGroup radioGroup;

    public FragmentPreguntas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentPreguntas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPreguntas newInstance(int state) {
        FragmentPreguntas fragment = new FragmentPreguntas();
        curr_state = state;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        switch (curr_state) {
            case DEPORTES:
                questions[0] = getString(R.string.deportes_question_1);
                questions[1] = getString(R.string.deportes_question_2);
                break;
            case TECNOLOGIA:
                questions[0] = getString(R.string.tecnologia_question_1);
                questions[1] = getString(R.string.tecnologia_question_2);
                break;
            default:
                break;
        }

        curr_question = 1;

        final View rootView = inflater.inflate(R.layout.fragment_preguntas, container, false);

        radioGroup = rootView.findViewById(R.id.rg_trueFalse);
        tv_question = rootView.findViewById(R.id.tv_pregunta);
        tv_currQuestion = rootView.findViewById(R.id.tv_currQuestion);
        next_btn = rootView.findViewById(R.id.btn_next);
        prev_btn = rootView.findViewById(R.id.btn_prev);
        checkAnswer = rootView.findViewById(R.id.btn_checkAns);

        changeQuestion(1);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                final int index = radioGroup.indexOfChild(radioButton);

                checkAnswer.setVisibility(View.VISIBLE);

                checkAnswer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (index) {
                            case FALSE:
                                if(!answers[curr_state - 10][curr_question - 1]) {
                                    Toast toast = Toast.makeText(getActivity(),"Correct Answer!", Toast.LENGTH_SHORT);
                                    toast.show();
                                } else {
                                    Toast toast = Toast.makeText(getActivity(),"Incorrect Answer!", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                break;
                            case TRUE:
                                if(answers[curr_state - 10][curr_question - 1]) {
                                    Toast toast = Toast.makeText(getActivity(), "Correct Answer!", Toast.LENGTH_SHORT);
                                    toast.show();
                                } else {
                                    Toast toast = Toast.makeText(getActivity(),"Incorrect Answer!", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                                break;
                        }
                    }
                });


            }
        });

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr_question -= 1;
                changeQuestion(curr_question);
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr_question += 1;
                changeQuestion(curr_question);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    // Harcodeado
    private void changeQuestion(int question) {
        tv_question.setText(questions[question - 1]);

        String currQuestionString = "[" + question + "/2]";
        tv_currQuestion.setText(currQuestionString);

        radioGroup.clearCheck();
        checkAnswer.setVisibility(View.INVISIBLE);

        switch (question) {
            case 1:
                // Deshabilitar prev
                prev_btn.setEnabled(false);
                next_btn.setEnabled(true);
                break;
            case 2: // Harcodeado
                // Deshabilitar next
                next_btn.setEnabled(false);
                prev_btn.setEnabled(true);
                break;
        }
    }
}