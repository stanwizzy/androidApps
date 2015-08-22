package com.example.stanleyopara.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.UUID;

public class CrimeActivity extends BaseFragmentActivity{

    @Override
    public Fragment getFragment(){

        UUID id = (UUID)getIntent().getSerializableExtra(CrimeFragment.CURRENT_KEY);
        CrimeFragment crimeFragment = CrimeFragment.newInstance(id);

        return  crimeFragment;
    }


}
