package edu.byuh.cis.cs203.SafarivsChrome.ui;

import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;

import edu.byuh.cis.cs203.SafarivsChrome.R;

public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        PreferenceScreen screen = getPreferenceManager()
                .createPreferenceScreen(this);

        //Sound Effects
        CheckBoxPreference sound = new CheckBoxPreference(this);
        sound.setTitle(R.string.BGM);
        sound.setSummaryOn(R.string.soundtrack_on);
        sound.setSummaryOff(R.string.soundtrack_off);
        sound.setChecked(true);
        sound.setKey("SOUNDFX");
        screen.addPreference(sound);

        //Speed Option
        ListPreference speed = new ListPreference(this);
        speed.setTitle(R.string.speed_label);
        speed.setSummary(R.string.speed_summary);
        speed.setKey("SPEED");
        String[] entries = {getResources().getString(R.string.speed_entry_fast), getResources().getString(R.string.speed_entry_medium), getResources().getString(R.string.speen_entry_slow)};
        String[] values = {"10", "50", "100"};
        speed.setEntries(entries);
        speed.setEntryValues(values);
        screen.addPreference(speed);

        setPreferenceScreen(screen);
    }

    public static boolean getSoundPref(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("SOUNDFX", true);

    }

    public static int getSpeed(Context c) {
        String speedpref = PreferenceManager.getDefaultSharedPreferences(c).getString("SPEED", "50");
        return Integer.parseInt(speedpref);
    }
}
