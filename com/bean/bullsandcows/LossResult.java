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
import android.widget.TextView;
import com.sxnyodot.uefqvmio207964.AdListener;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.Prm;

public class LossResult extends Activity implements OnClickListener {
    private Prm prm;
    TextView result;
    Button tryagain;

    /* renamed from: com.bean.bullsandcows.LossResult.1 */
    class C03421 implements AdListener {
        C03421() {
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
        setContentView(C0047R.layout.loss);
        if (this.prm == null) {
            this.prm = new Prm(this, null, false);
        }
        AdListener adCallbackListener = new C03421();
        Intent i = getIntent();
        String res = i.getExtras().getString("res");
        i.removeExtra("res");
        Animation shake = AnimationUtils.loadAnimation(this, C0047R.anim.shake);
        this.tryagain = (Button) findViewById(C0047R.id.tryagain);
        this.result = (TextView) findViewById(C0047R.id.finalresult);
        this.result.setTypeface(null, 1);
        this.result.setText("Code: " + res);
        this.tryagain.setAnimation(shake);
        this.tryagain.setOnClickListener(this);
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
            Intent ourIntent = new Intent(this, Class.forName("com.bean.bullsandcows.Home"));
            ourIntent.removeExtra("res");
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
