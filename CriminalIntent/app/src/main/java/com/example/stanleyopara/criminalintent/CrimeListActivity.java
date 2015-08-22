package com.example.stanleyopara.criminalintent;


import android.support.v4.app.Fragment;

public class CrimeListActivity extends BaseFragmentActivity{

        @Override
        public Fragment getFragment(){
            return new CrimeListFragment();
        }

}
