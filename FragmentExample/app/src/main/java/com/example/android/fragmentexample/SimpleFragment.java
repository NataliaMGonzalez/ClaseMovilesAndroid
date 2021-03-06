package com.example.android.fragmentexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {
    // Reference to interface
    CommListener mListener;

    // yes at index 0, no at index 1
    private static final int YES = 0;
    private static final int NO  = 1;
    private static int NONE = 2;

    public int mRadioButtonChoice = NONE;

    // Create interface
    interface CommListener{
        void onRadioButtonChoice(int choice);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof CommListener){
            mListener = (CommListener)context;
        }
        else{
            throw new ClassCastException(context.toString() + " You nee to implement interface CommListener");
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SimpleFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SimpleFragment newInstance() {
        SimpleFragment fragment = new SimpleFragment();
        // Bundle args = new Bundle();
        // args.putString(ARG_PARAM1, param1);
        // args.putString(ARG_PARAM2, param2);
        // fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         //   mParam1 = getArguments().getString(ARG_PARAM1);
         //   mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // clicked button
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);

                TextView txtView = rootView.findViewById(R.id.fragmentHeader);

                switch (index){
                    case YES: //user chose yes
                        txtView.setText(R.string.yes_message);
                        mRadioButtonChoice = YES;
                        mListener.onRadioButtonChoice(YES);
                        break;

                    case NO:
                        txtView.setText(R.string.no_message);
                        mRadioButtonChoice = NO;
                        mListener.onRadioButtonChoice(NO);
                        break;

                    default:
                        mRadioButtonChoice = NONE;
                        mListener.onRadioButtonChoice(NONE);
                        break;
                }

            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }
}