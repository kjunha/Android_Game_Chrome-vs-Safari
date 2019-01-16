package edu.byuh.cis.cs203.SafarivsChrome.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import edu.byuh.cis.cs203.SafarivsChrome.logic.GameMode;

/**
 * Our "main" class. Everything starts here.
 */
public class MainActivity extends Activity {

    private GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mode = getIntent();
        String playmode = mode.getStringExtra("GameMode");
        if(playmode.equals("ONE_PLAYER")) {
            gv = new GameView(this, GameMode.ONE_PLAYER);
        } else {
            gv = new GameView(this, GameMode.TWO_PLAYER);
        }
        setContentView(gv);
    }

    public static float findThePerfectFontSize(float dim) {
        float fontSize = 1;
        Paint p = new Paint();
        p.setTextSize(fontSize);
        float lowerThreshold = dim;
        while (true) {
            float asc = -p.getFontMetrics().ascent;
            if (asc > lowerThreshold) {
                break;
            }
            fontSize++;
            p.setTextSize(fontSize);
        }
        return fontSize;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gv.shutdown();
        gv.unloadMusic();
    }

    @Override
    protected void onPause(){
        super.onPause();
        gv.pauseMusic();

    }

    @Override
    protected void onResume() {
        super.onResume();
        gv.restartMusic();

    }


}