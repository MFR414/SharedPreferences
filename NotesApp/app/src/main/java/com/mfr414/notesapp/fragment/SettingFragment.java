package com.mfr414.notesapp.fragment;


import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import com.mfr414.notesapp.R;

public class SettingFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
