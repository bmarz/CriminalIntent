package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by Admin on 7/26/2017.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<UUID> mCrimeIds;
    private HashMap<UUID, Crime> mCrimes = new HashMap<>(); // added per chapter 10 challenge

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context) {
        mCrimeIds = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.put(crime.getId(), crime); // I added this per chapter 10 challenge
            mCrimeIds.add(crime.getId());
        }
    }

    public List<Crime> getCrimes() {
        List<Crime> crimeList = new ArrayList<>();
        for (UUID id : mCrimeIds) {
            crimeList.add(mCrimes.get(id));
        }
        return crimeList;
    }

    public Crime getCrime(UUID id) {
        if (mCrimeIds.contains(id)) {
            return mCrimes.get(id);
        }
        return null;
//        for (Crime crime : mCrimes) {
//            if (crime.getId().equals(id)) {
//                return crime;
//            }
//        }
//        return null;
    }
}
