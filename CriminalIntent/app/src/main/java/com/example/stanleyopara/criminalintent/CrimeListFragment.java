package com.example.stanleyopara.criminalintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CrimeListFragment extends ListFragment {

    private List<Crime> mCrimes;

    @Override
    public void onCreate(Bundle saveInstantState){
        super.onCreate(saveInstantState);
        mCrimes = CrimeLab.getCrimeLab(getActivity()).getCrimes();

        //ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,mCrimes);
         CrimeAdapter arrayAdapter = new CrimeAdapter(mCrimes);
        setListAdapter(arrayAdapter);

    }

    @Override
    public void onResume(){
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView i, View v,int pos,long id){

        Crime crime = (Crime)getListAdapter().getItem(pos);
        Intent intent = new Intent(getActivity(),CrimePagerActivity.class);
        intent.putExtra(CrimeFragment.CURRENT_KEY, crime.getId());
        startActivity(intent);
    }
        private class CrimeAdapter extends ArrayAdapter<Crime> {

            public CrimeAdapter(List<Crime> mCrimes){
            super(getActivity(),0,mCrimes);
            }

        @Override
        public View getView(int position, View convertView,ViewGroup parent){

            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime,null);
            }

            Crime crime = getItem(position);
            TextView view1 = (TextView)convertView.findViewById(R.id.single_crime_title);
            view1.setText(crime.getTitle());

            TextView view2 = (TextView)convertView.findViewById(R.id.single_crime_date);
            view2.setText(crime.getDate().toString());

            CheckBox view3 = (CheckBox)convertView.findViewById(R.id.single_solved_checkbox);
            view3.setChecked(crime.isSolved());
            return convertView;

        }
    }
}
