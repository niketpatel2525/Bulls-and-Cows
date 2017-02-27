package com.bean.bullsandcows;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.sxnyodot.uefqvmio207964.AdListener;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.Prm;

public class Home extends Activity implements OnClickListener {
    Button aboutus;
    Button help;
    MediaPlayer home;
    private Prm prm;
    Animation shake;
    Button start;

    /* renamed from: com.bean.bullsandcows.Home.1 */
    class C03411 implements AdListener {
        C03411() {
        }

        public void onSDKIntegrationError(String message) {
        }

        public void onSmartWallAdShowing() {
        }

        public void onSmartWallAdClosed() {
        }

        public void onAdError(String message) {
        }

        public void onAdCached(AdType arg0) {
        }

        public void noAdAvailableListener() {
        }
    }

    protected void onPause() {
        super.onPause();
        this.home.stop();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        if (this.prm == null) {
            this.prm = new Prm(this, null, false);
        }
        AdListener adCallbackListener = new C03411();
        this.home = MediaPlayer.create(this, C0047R.raw.startup);
        this.home.setLooping(true);
        this.home.start();
        setContentView(C0047R.layout.front);
        this.shake = AnimationUtils.loadAnimation(this, C0047R.anim.shake);
        this.start = (Button) findViewById(C0047R.id.start);
        this.aboutus = (Button) findViewById(C0047R.id.about);
        this.help = (Button) findViewById(C0047R.id.help);
        startAnimation();
        this.start.setOnClickListener(this);
        this.aboutus.setOnClickListener(this);
        this.help.setOnClickListener(this);
    }

    private void startAnimation() {
        this.start.startAnimation(this.shake);
        this.aboutus.startAnimation(this.shake);
        this.help.startAnimation(this.shake);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0047R.id.about:
                try {
                    this.home.stop();
                    startActivity(new Intent(this, Class.forName("com.bean.bullsandcows.About")));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            case C0047R.id.help:
                try {
                    this.home.stop();
                    startActivity(new Intent(this, Class.forName("com.bean.bullsandcows.Help")));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                }
            case C0047R.id.start:
                try {
                    this.home.stop();
                    startActivity(new Intent(this, Class.forName("com.bean.bullsandcows.MainActivity")));
                } catch (ClassNotFoundException e22) {
                    e22.printStackTrace();
                }
            default:
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        try {
            this.prm.runCachedAd(this, AdType.smartwall);
        } catch (Exception e) {
            super.onBackPressed();
        }
        this.home.stop();
        finish();
    }
}
