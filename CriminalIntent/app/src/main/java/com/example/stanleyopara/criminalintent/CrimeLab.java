package com.example.stanleyopara.criminalintent;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private List<Crime> mCrimes;

    private CrimeLab(Context appContext,int numCrimes){

        mCrimes = new ArrayList<>();
        this.mAppContext = appContext;
        for (int i =0; i < numCrimes; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime # " + i);
            crime.setDate();
            crime.setSolved((i % 2) == 0);
            mCrimes.add(crime);
        }

    }

    public static CrimeLab getCrimeLab(Context appContext){

        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(appContext,100);
        }
        return sCrimeLab;
    }

    public Context getAppContext() {
        return mAppContext;
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }


    public Crime getCrime(UUID id){
        for (Crime crime: mCrimes){
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
