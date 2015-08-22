package com.example.stanleyopara.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by stanleyopara on 8/14/15.
 */
public class Crime {

    private UUID id;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        this.id = UUID.randomUUID();
        this.mSolved = false;

    }

    public String getTitle(){
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate() {
        this.mDate = new Date();
    }

    public void setDate(Date date) {
        this.mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        this.mSolved = solved;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public UUID getId(){
        return id;
    }

    @Override
    public String toString(){
        return mTitle;
    }
}
