package edu.byuh.cis.cs203.SafarivsChrome.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import edu.byuh.cis.cs203.SafarivsChrome.R;

public class SplashActivity extends Activity {

    private ImageView sv;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        sv = new ImageView(this);
        sv.setImageResource(R.drawable.splashscreen);
        sv.setScaleType(ImageView.ScaleType.FIT_XY);
        setContentView(sv);
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {
        if(m.getAction() == MotionEvent.ACTION_UP) {
            float w = sv.getWidth();
            float h = sv.getHeight();
            RectF onep = new RectF(w*(116.3f/600f),h*(650.9f/1024f),w*(484.7f/600f),h*(777.2f/1024f));
            RectF twop = new RectF(w*(116.2f/600f),h*(796.2f/1024f),w*(484.7f/600f),h*(922.6f/1024f));
            RectF info = new RectF(w*(32.0f/600f),h*(53.6f/1024f),w*(123.9f/600f),h*(145.5f/1024f));
            RectF sett = new RectF(w*(475.1f/600f),h*(53.6f/1024f),w*(567.0f/600f),h*(145.45f/1024f));
            float x = m.getX();
            float y = m.getY();
            if(onep.contains(x,y)){
                Intent oneplayer = new Intent(this, MainActivity.class);
                oneplayer.putExtra("GameMode", "ONE_PLAYER");
                startActivity(oneplayer);
                finish();
            } else if(twop.contains(x,y)){
                Intent twoplayer = new Intent(this, MainActivity.class);
                twoplayer.putExtra("GameMode", "TWO_PLAYER");
                startActivity(twoplayer);
                finish();
            } else if(info.contains(x,y)){
                AlertDialog.Builder ab = new AlertDialog.Builder(this);
                ab.setMessage("App Info")
                        .setTitle(R.string.app_info)
                        .setMessage(R.string.app_info_des)
                        .setPositiveButton(R.string.ok_label, null);
                AlertDialog box = ab.create();
                box.show();

            } else if (sett.contains(x,y)) {
                Intent pref = new Intent(this, Prefs.class);
                startActivity(pref);
            }
        }
        return true;
    }
}
