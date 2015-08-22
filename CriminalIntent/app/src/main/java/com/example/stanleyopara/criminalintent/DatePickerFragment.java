package com.example.stanleyopara.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.Inflater;


public class DatePickerFragment extends android.support.v4.app.DialogFragment {

    public static final String DATE_KEY="date_key";
    private DatePicker mDatePicker;

    public static DatePickerFragment newInstance(Date date) {

        Bundle args = new Bundle();
        args.putSerializable(DATE_KEY,date);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_date_picker,null);
        mDatePicker = (DatePicker)v.findViewById(R.id.crime_date_picker);
        v = initDatePicker(v);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int year = mDatePicker.getYear();
                                int day = mDatePicker.getDayOfMonth();
                                int month = mDatePicker.getMonth();
                                Date date = new GregorianCalendar(year,month,day).getTime();
                                Log.d("ginger", " " + year + " " + month + day);
                                sendResults(date);
                            }
                        })
                .create();
    }

    private void sendResults(Date date){

        Intent intent = new Intent();
        intent.putExtra(CrimeFragment.DATE_RESULT,date);
        getTargetFragment().onActivityResult(getTargetRequestCode(),200,intent);
    }

    private View initDatePicker(View v){

        Date date = (Date)getArguments().getSerializable(DATE_KEY);
        if(date == null){
            return v;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePicker datePicker = (DatePicker)v.findViewById(R.id.crime_date_picker);
        datePicker.init(year,month,day,null);
        return v;
    }
}
