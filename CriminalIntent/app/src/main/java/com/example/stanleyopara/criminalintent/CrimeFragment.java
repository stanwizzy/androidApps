package com.example.stanleyopara.criminalintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {


    private Crime mCrime;
    private Button mButton;
    private CheckBox mCheckbox;
    private static CrimeFragment sFragment;
    public static final String CURRENT_KEY = "current_key";
    public static final String DATE_FRAGMENT_KEY="date_fragment_key";
    public static final int REQUEST_CODE=0;
    public static final String DATE_RESULT="date_result";


    public static CrimeFragment newInstance(UUID uuid){
        Bundle bundle = new Bundle();
        bundle.putSerializable(CURRENT_KEY,uuid);
        sFragment = new CrimeFragment();
        sFragment.setArguments(bundle);
        return sFragment;
    }

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        UUID id = (UUID)getArguments().getSerializable(CURRENT_KEY);
        if(id != null){
            mCrime=CrimeLab.getCrimeLab(getActivity()).getCrime(id);
        }else {
            mCrime = new Crime();
        }

    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent intent){

        if (requestCode == REQUEST_CODE){
            Date date = (Date)intent.getSerializableExtra(DATE_RESULT);
            mCrime.setDate(date);
            mButton.setText(mCrime.getDate().toString());
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mButton = (Button)v.findViewById(R.id.crime_date);
        //mCrime.setDate();
        mButton.setText(mCrime.getDate().toString());
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DatePickerFragment fragment = DatePickerFragment.newInstance(mCrime.getDate());
                fragment.setTargetFragment(CrimeFragment.this,REQUEST_CODE);
                fragment.show(fm, DATE_FRAGMENT_KEY);
            }
        });


        mCheckbox = (CheckBox)v.findViewById(R.id.crime_status);
        mCheckbox.setChecked(mCrime.isSolved());
        mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });


        EditText editText = (EditText)v.findViewById(R.id.crime_title);
        editText.setText(mCrime.getTitle());
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        return v;
    }

}
