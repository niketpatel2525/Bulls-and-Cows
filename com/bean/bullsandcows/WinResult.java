package com.bean.bullsandcows;

import android.app.Activity;
import android.content.Intent;
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

public class WinResult extends Activity implements OnClickListener {
    Button playagain;
    private Prm prm;

    /* renamed from: com.bean.bullsandcows.WinResult.1 */
    class C03431 implements AdListener {
        C03431() {
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setContentView(C0047R.layout.win);
        if (this.prm == null) {
            this.prm = new Prm(this, null, false);
        }
        AdListener adCallbackListener = new C03431();
        Animation shake = AnimationUtils.loadAnimation(this, C0047R.anim.shake);
        this.playagain = (Button) findViewById(C0047R.id.playagain);
        this.playagain.setAnimation(shake);
        this.playagain.setOnClickListener(this);
    }

    public void onClick(View v) {
        try {
            startActivity(new Intent(this, Class.forName("com.bean.bullsandcows.MainActivity")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        try {
            startActivity(new Intent(this, Class.forName("com.bean.bullsandcows.Home")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
